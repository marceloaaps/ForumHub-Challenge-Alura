package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

//Falta adicionar Resposta

public record TopicoDto(Long id,
                        @NotBlank String titulo,
                        @NotBlank String mensagem,
                        @NotNull LocalDateTime dataCriacao,
                        boolean status,
                        @NotNull UsuarioDto autor,
                        @NotNull CursoDto curso) implements Serializable {
}