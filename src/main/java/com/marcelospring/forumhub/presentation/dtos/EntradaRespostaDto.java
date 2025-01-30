package com.marcelospring.forumhub.presentation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntradaRespostaDto(   @NotBlank String mensagem,
                                    @NotNull @JsonProperty(value = "autor") Long autorId,
                                    @NotNull @JsonProperty(value = "topico") Long topicoId) {}
