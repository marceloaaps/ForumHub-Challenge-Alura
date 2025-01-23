package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record PerfilDto(Long id, @NotBlank String name) implements Serializable {
}