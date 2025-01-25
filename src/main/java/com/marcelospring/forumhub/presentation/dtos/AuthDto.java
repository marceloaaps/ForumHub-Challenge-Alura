package com.marcelospring.forumhub.presentation.dtos;

import com.marcelospring.forumhub.core.domain.entities.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthDto(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String senha, @NotNull Long role) {
}
