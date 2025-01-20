package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.domain.entities.Curso;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import org.mapstruct.Mapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import com.marcelospring.forumhub.core.domain.entities.Topico;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TopicoMapper {
    @Mapping(target = "autor", source = "autor", qualifiedByName = "mapLongToUsuario") // Usando o método de conversão
    @Mapping(target = "curso", source = "curso", qualifiedByName = "mapLongToCurso") // Usando o método de conversão
    Topico toEntity(TopicoDto topicoDto);

    @Mapping(target = "autor", source = "autor", qualifiedByName = "mapUsuarioToLong") // Usando o método de conversão
    @Mapping(target = "curso", source = "curso", qualifiedByName = "mapCursoToLong") // Usando o método de conversão
    TopicoDto toDto(Topico topico);

    // Mapeamento de Usuario para Long
    @org.mapstruct.Named("mapUsuarioToLong")
    default Long mapUsuarioToLong(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return usuario.getId();  // Supondo que o ID do usuário seja do tipo Long
    }

    // Mapeamento de Curso para Long
    @org.mapstruct.Named("mapCursoToLong")
    default Long mapCursoToLong(Curso curso) {
        if (curso == null) {
            return null;
        }
        return curso.getId();  // Supondo que o ID do curso seja do tipo Long
    }

    // Mapeamento de Long para Usuario
    @org.mapstruct.Named("mapLongToUsuario")
    default Usuario mapLongToUsuario(Long id) {
        if (id == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(id);  // Definindo o ID do usuário
        return usuario;
    }

    // Mapeamento de Long para Curso
    @org.mapstruct.Named("mapLongToCurso")
    default Curso mapLongToCurso(Long id) {
        if (id == null) {
            return null;
        }
        Curso curso = new Curso();
        curso.setId(id);  // Definindo o ID do curso
        return curso;
    }
}


