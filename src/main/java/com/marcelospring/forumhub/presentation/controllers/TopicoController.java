package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.use_cases.curso.RetornarCursoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.CriarTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.deletar.DeletarTopicoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoDtoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByIdUseCase;
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
    private final RetornarTopicoDtoByIdUseCase retornarTopicoDtoByIdUseCase;
    private final DeletarTopicoByIdUseCase deletarTopicoByIdUseCase;
    private final RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase;
    private final RetornarCursoByIdUseCase retornarCursoByIdUseCase;


    public TopicoController(CriarTopicoUseCase criarTopicoUseCase,
                            RetornarTopicoUseCase retornarTopicoUseCase,
                            RetornarTopicoDtoByIdUseCase retornarTopicoDtoByIdUseCase,
                            DeletarTopicoByIdUseCase deletarTopicoByIdUseCase,
                            RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase,
                            RetornarCursoByIdUseCase retornarCursoByIdUseCase
    ) {

        this.criarTopicoUseCase = criarTopicoUseCase;
        this.retornarTopicoUseCase = retornarTopicoUseCase;
        this.retornarTopicoDtoByIdUseCase = retornarTopicoDtoByIdUseCase;
        this.deletarTopicoByIdUseCase = deletarTopicoByIdUseCase;
        this.retornarUsuarioByIdUseCase = retornarUsuarioByIdUseCase;
        this.retornarCursoByIdUseCase = retornarCursoByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> criarTopico(@Valid @RequestBody String titulo, String mensagem, Boolean status, Long idAutor, Long idCurso) {

        var usuarioDto = retornarUsuarioByIdUseCase.retornarUsuario(idAutor);
        var cursoDto = retornarCursoByIdUseCase.retornarCurso(idCurso);

        var topicoDto = new TopicoDto(titulo, mensagem, status, usuarioDto, cursoDto);

        criarTopicoUseCase.criarTopico(topicoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    public Page<Topico> getTopicos() {
        return retornarTopicoUseCase.findAllByOrderByDataCriacaoDesc();
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable("id") Long id) {
        return deletarTopicoByIdUseCase.deletar(id);
    }




}
