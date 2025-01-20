package com.marcelospring.forumhub.infra.adapters;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import org.mapstruct.Mapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import com.marcelospring.forumhub.core.domain.entities.Topico;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TopicoMapper {

    @Mapping(target = "autor", source = "autorDtoId", qualifiedByName = "mapLongToUsuario")
    Topico toEntity(TopicoDto topicoDto);
    TopicoDto toDto(Topico topico);

    @Named("mapLongToUsuario")
    default Usuario mapLongToUsuario(Long autorId) {
        if (autorId == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(autorId);
        return usuario;
    }
}