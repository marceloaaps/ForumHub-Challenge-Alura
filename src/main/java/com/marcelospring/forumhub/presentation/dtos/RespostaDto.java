package com.marcelospring.forumhub.presentation.dtos;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;


public record RespostaDto(@NotBlank String mensagem, @NotNull Topico topico,  @NotNull Usuario autor, @NotNull LocalDateTime dataCriacao,
                          boolean isDeleted) implements Serializable {
}