package com.marcelospring.forumhub.infra.mappers;

import com.marcelospring.forumhub.core.domain.entities.Curso;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import org.mapstruct.Mapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import com.marcelospring.forumhub.core.domain.entities.Topico;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring")
public interface TopicoMapper {
    @Mapping(target = "autor", source = "autor", qualifiedByName = "mapLongToUsuario")
    @Mapping(target = "curso", source = "curso", qualifiedByName = "mapLongToCurso")
    Topico toEntity(TopicoDto topicoDto);

    @Mapping(target = "autor", source = "autor", qualifiedByName = "mapUsuarioToLong")
    @Mapping(target = "curso", source = "curso", qualifiedByName = "mapCursoToLong")
    TopicoDto toDto(Topico topico);


    @Named("mapUsuarioToLong")
    default Long mapUsuarioToLong(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return usuario.getId();
    }

    @Named("mapCursoToLong")
    default Long mapCursoToLong(Curso curso) {
        if (curso == null) {
            return null;
        }
        return curso.getId();
    }

    @Named("mapLongToUsuario")
    default Usuario mapLongToUsuario(Long id) {
        if (id == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(id);
        return usuario;
    }

    @Named("mapLongToCurso")
    default Curso mapLongToCurso(Long id) {
        if (id == null) {
            return null;
        }
        Curso curso = new Curso();
        curso.setId(id);
        return curso;
    }
}


