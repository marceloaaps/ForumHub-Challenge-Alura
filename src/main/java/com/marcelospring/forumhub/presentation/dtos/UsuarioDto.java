package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(Long id, @NotBlank String nome, @NotBlank @Email String email, @NotBlank String senha){

    public UsuarioDto(String nome, String email, String senha){
        this(null, nome, email, senha);
    }
}