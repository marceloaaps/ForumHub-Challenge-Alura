package com.marcelospring.forumhub.presentation.dtos;

import java.io.Serializable;

/**
 * DTO for {@link com.marcelospring.forumhub.core.domain.entities.Perfil}
 */
public record PerfilDto(Long id, String name) implements Serializable {
}