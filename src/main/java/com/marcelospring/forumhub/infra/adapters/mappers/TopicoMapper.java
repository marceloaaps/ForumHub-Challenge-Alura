package com.marcelospring.forumhub.infra.adapters.mappers;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TopicoMapper {

    TopicoMapper INSTANCE = Mappers.getMapper(TopicoMapper.class);

    Topico toEntity(TopicoDto topicoDto);

    TopicoDto toDto(Topico topico);

}
