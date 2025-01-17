package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.core.use_cases.curso.ConverteCursoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.CriarTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.RetornarTopicoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.RetornarTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.ConverteUsuarioUseCase;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {

    private final CriarTopicoUseCase criarTopicoUseCase;
    private final RetornarTopicoUseCase retornarTopicoUseCase;
    private final RetornarTopicoByIdUseCase retornarTopicoByIdUseCase;
    private final ConverteUsuarioUseCase converteUsuarioUseCase;
    private final ConverteCursoUseCase converteCursoUseCase;
    private final TopicoRepository topicoRepository;


    public TopicoController(CriarTopicoUseCase criarTopicoUseCase,
                            RetornarTopicoUseCase retornarTopicoUseCase,
                            RetornarTopicoByIdUseCase retornarTopicoByIdUseCase,
                            ConverteUsuarioUseCase converteUsuarioUseCase, ConverteCursoUseCase converteCursoUseCase, TopicoRepository topicoRepository) {

        this.criarTopicoUseCase = criarTopicoUseCase;
        this.retornarTopicoUseCase = retornarTopicoUseCase;
        this.retornarTopicoByIdUseCase = retornarTopicoByIdUseCase;
        this.converteUsuarioUseCase = converteUsuarioUseCase;
        this.converteCursoUseCase = converteCursoUseCase;
        this.topicoRepository = topicoRepository;
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

    @GetMapping("/{id}")
    public TopicoDto getTopico(@PathVariable("id") Long id) {

        Topico topico = retornarTopicoByIdUseCase.retornarTopicoById(id);

        var topicoDto = converteUsuarioUseCase.converteUsuario(topico.getAutor());
        var cursoDto = converteCursoUseCase.converteCurso(topico.getCurso());

        return new TopicoDto(topico, topicoDto, cursoDto);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Topico> atualizarTopico(
            @PathVariable("id") Long id,
            @RequestBody @Valid TopicoDto topicoDto) {

        var topicoAntigo = retornarTopicoByIdUseCase.retornarTopicoById(id);

        if (topicoAntigo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        topicoAntigo.setTitulo(topicoDto.titulo());
        topicoAntigo.setMensagem(topicoDto.mensagem());
        topicoAntigo.setStatus(topicoDto.status());

        topicoRepository.save(topicoAntigo);

        return ResponseEntity.ok(topicoAntigo);
    }


}
