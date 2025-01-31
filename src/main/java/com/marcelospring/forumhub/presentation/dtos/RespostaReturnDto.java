package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RespostaReturnDto(@NotBlank String message,
                                @NotBlank String topico,
                                @NotBlank String autor,
                                @NotNull LocalDateTime dataCriacao) {
}
