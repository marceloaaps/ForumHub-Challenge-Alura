package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.domain.entities.Curso;
import com.marcelospring.forumhub.presentation.dtos.CursoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CursoMapper {
    CursoDto toDto(Curso curso);
    Curso toEntity(CursoDto cursoDto);
}
