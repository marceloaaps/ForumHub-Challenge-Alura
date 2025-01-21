package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(Long id,
                         @NotBlank String nome, String email, String senha){
}