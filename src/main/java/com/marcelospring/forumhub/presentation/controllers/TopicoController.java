package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.use_cases.topico.CriarTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.RetornarTopicoUseCase;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {

    private final CriarTopicoUseCase criarTopicoUseCase;
    private final RetornarTopicoUseCase retornarTopicoUseCase;


    public TopicoController(CriarTopicoUseCase criarTopicoUseCase, RetornarTopicoUseCase retornarTopicoUseCase) {
        this.criarTopicoUseCase = criarTopicoUseCase;
        this.retornarTopicoUseCase = retornarTopicoUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> criarTopico(@Valid @RequestBody TopicoDto topicoDto) {

        criarTopicoUseCase.criarTopico(topicoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    public Page<Topico> getTopicos() {
        return retornarTopicoUseCase.findAllByOrderByDataCriacaoDesc();
    }
}
