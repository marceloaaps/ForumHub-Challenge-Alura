package com.marcelospring.forumhub.infra.adapters.mappers;

import com.marcelospring.forumhub.core.domain.entities.Curso;
import com.marcelospring.forumhub.presentation.dtos.CursoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    CursoMapper toEntity(CursoDto cursoDto);

    CursoDto toDto(Curso curso);


}
