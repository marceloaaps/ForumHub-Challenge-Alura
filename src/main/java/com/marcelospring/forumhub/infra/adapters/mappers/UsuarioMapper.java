package com.marcelospring.forumhub.infra.adapters.mappers;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toEntity(UsuarioDto usuarioDto);

    UsuarioDto toDto(Usuario usuario);

}
