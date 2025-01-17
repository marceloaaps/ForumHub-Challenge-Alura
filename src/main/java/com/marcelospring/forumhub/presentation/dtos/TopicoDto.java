package com.marcelospring.forumhub.presentation.dtos;

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
}
