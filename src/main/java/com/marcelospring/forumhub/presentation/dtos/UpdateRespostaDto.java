package com.marcelospring.forumhub.presentation.dtos;

import jakarta.validation.constraints.NotBlank;

public record UpdateRespostaDto(@NotBlank String message) {
}
