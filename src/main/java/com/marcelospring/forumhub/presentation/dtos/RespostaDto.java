package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;


public record RespostaDto(@NotBlank String mensagem, @NotNull Long topicoId,
                          @NotNull Long autorId) implements Serializable {
}