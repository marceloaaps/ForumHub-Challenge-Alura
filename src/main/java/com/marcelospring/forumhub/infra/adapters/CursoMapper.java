package com.marcelospring.forumhub.infra.adapters;

import com.marcelospring.forumhub.core.domain.entities.Curso;
import com.marcelospring.forumhub.presentation.dtos.CursoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CursoMapper {
    CursoDto toDto(Curso curso);
}
