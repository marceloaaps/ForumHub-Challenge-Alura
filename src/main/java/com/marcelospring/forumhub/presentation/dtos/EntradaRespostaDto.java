package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntradaRespostaDto(   @NotBlank String message,
                                    @NotNull Long autorId,
                                    @NotNull Long topicoId) {}
