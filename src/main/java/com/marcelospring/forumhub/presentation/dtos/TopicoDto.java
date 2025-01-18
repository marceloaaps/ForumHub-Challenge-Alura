package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record TopicoDto(@NotBlank String titulo,
                        @NotBlank String mensagem,
                        @NotNull Boolean status,
                        @Valid @NotNull UsuarioDto autor,
                        @Valid @NotNull CursoDto curso) {

}
