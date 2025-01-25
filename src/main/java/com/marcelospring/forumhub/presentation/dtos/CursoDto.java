package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


public record CursoDto(@NotNull Long id, @NotBlank String name, @NotBlank String categoria) implements Serializable {
}