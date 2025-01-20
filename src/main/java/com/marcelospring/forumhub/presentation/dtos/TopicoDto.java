package com.marcelospring.forumhub.presentation.dtos;

import com.marcelospring.forumhub.core.domain.entities.Curso;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import jakarta.validation.constraints.NotBlank;


public record TopicoDto(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        Boolean status,
        Usuario autor,
        Curso curso
) {
}