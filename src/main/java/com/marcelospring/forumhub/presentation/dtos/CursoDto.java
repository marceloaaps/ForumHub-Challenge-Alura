package com.marcelospring.forumhub.presentation.dtos;

import java.io.Serializable;

public record CursoDto(Long id, String name, String categoria) implements Serializable {
}