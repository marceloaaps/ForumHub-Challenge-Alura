package com.marcelospring.forumhub.infra.adapters;

import org.mapstruct.Mapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import com.marcelospring.forumhub.core.domain.entities.Topico;

@Mapper(componentModel = "spring")
public interface TopicoMapper {
    Topico toEntity(TopicoDto topicoDto);
    TopicoDto toDto(Topico topico);
}