package com.marcelospring.forumhub;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.infra.mappers.UsuarioMapper;
import com.marcelospring.forumhub.presentation.controllers.UsuarioMapperImpl;
import com.marcelospring.forumhub.presentation.dtos.PerfilDto;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JsonIgnoreType
public class UsuarioMapperTest {

    private final UsuarioMapper usuarioMapper = new UsuarioMapperImpl();

    @Test
    public void testToEntity() {
        UsuarioDto dto = new UsuarioDto(1L, "John Doe", "johnemail@email.com", "1234");


        Usuario usuario = usuarioMapper.toEntity(dto);

        assertNotNull(usuario);
        assertEquals(dto.id(), usuario.getId());
        assertEquals(dto.nome(), usuario.getNome());
    }

    @Test
    public void testToDto() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("John Doe");

        UsuarioDto dto = usuarioMapper.toDto(usuario);

        assertNotNull(dto);
        assertEquals(usuario.getId(), dto.id());
        assertEquals(usuario.getNome(), dto.nome());
    }
}
