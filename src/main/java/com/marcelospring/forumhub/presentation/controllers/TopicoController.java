package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.use_cases.topico.deletar.SoftDeleteTopicoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.criar.CriarTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoDtoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoUseCase;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {

    private final CriarTopicoUseCase criarTopicoUseCase;
    private final RetornarTopicoUseCase retornarTopicoUseCase;
    private final RetornarTopicoDtoByIdUseCase retornarTopicoDtoByIdUseCase;
    private final SoftDeleteTopicoByIdUseCase softDeleteTopicoByIdUseCase;

    public TopicoController(CriarTopicoUseCase criarTopicoUseCase,
                            RetornarTopicoUseCase retornarTopicoUseCase,
                            RetornarTopicoDtoByIdUseCase retornarTopicoDtoByIdUseCase, SoftDeleteTopicoByIdUseCase softDeleteTopicoByIdUseCase
                            ) {

        this.criarTopicoUseCase = criarTopicoUseCase;
        this.retornarTopicoUseCase = retornarTopicoUseCase;
        this.retornarTopicoDtoByIdUseCase = retornarTopicoDtoByIdUseCase;
        this.softDeleteTopicoByIdUseCase = softDeleteTopicoByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> criarTopico(@RequestBody @Valid TopicoDto topicoDto) {

        criarTopicoUseCase.criarTopico(topicoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    public ResponseEntity<Page<TopicoDto>> getTopicos(Pageable pageable) {
        Page<TopicoDto> topicos = retornarTopicoUseCase.findAll(pageable);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public TopicoDto getTopico(@PathVariable("id") Long id) {
        return retornarTopicoDtoByIdUseCase.retornarTopicoDtoById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDto> atualizarTopico(
            @PathVariable("id") Long id,
            @RequestBody @Valid TopicoDto topicoDto) {

        var topicoAntigo = retornarTopicoDtoByIdUseCase.retornarTopicoDtoById(id);

        if (topicoAntigo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        criarTopicoUseCase.criarTopico(topicoAntigo);

        return ResponseEntity.ok(topicoDto);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable("id") Long id) {

        var topicoDto = softDeleteTopicoByIdUseCase.deletarTopico(id);

        if (topicoDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.noContent().build();

    }
}
