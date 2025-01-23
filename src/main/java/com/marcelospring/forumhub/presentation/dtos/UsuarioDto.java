package com.marcelospring.forumhub.presentation.dtos;

import com.marcelospring.forumhub.core.domain.entities.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(Long id, @NotBlank String nome, @NotBlank @Email String email, @NotBlank String senha, @NotBlank Perfil role) {

}