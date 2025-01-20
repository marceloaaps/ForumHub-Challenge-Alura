package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioDto usuarioDto);
    UsuarioDto toDto(Usuario usuario);
}
