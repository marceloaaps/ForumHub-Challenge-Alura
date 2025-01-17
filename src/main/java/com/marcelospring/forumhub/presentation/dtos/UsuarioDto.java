package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

public record UsuarioDto(Long id,
                         @NotBlank String nome, String email, String senha,
                         List<PerfilDto> perfis) implements Serializable {
}