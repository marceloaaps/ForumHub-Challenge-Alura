package com.marcelospring.forumhub.presentation.dtos;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoDto(Long id,
                        @NotBlank String titulo,
                        @NotBlank String mensagem,
                        Boolean status,
                        @Valid @NotNull UsuarioDto autor,
                        @Valid @NotNull CursoDto curso) {

    public TopicoDto(Topico topico, UsuarioDto autor, CursoDto curso) {
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.autor = autor;
        this.curso = curso;
    }
}
