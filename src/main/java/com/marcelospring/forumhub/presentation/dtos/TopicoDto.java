package com.marcelospring.forumhub.presentation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record TopicoDto(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        Boolean status,
        @NotNull Long autor,
        @NotNull Long curso
) {
}