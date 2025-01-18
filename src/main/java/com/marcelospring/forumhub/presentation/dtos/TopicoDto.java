package com.marcelospring.forumhub.presentation.dtos;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record TopicoDto(Long id,
                        @NotBlank String titulo,
                        @NotBlank String mensagem,
                        Boolean status,
                        @Valid @NotNull UsuarioDto autor,
                        @Valid @NotNull CursoDto curso) {

}
