package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.infra.mappers.UsuarioMapper;
import com.marcelospring.forumhub.presentation.dtos.AuthDto;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverteUsuarioUseCase {

    private final UsuarioMapper usuarioMapper;

    @Autowired
    public ConverteUsuarioUseCase(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    public Usuario converteUsuarioByAuth(AuthDto authDto) {
        return new Usuario(authDto.nome(), authDto.email(), authDto.senha(), authDto.role());

    }

    public UsuarioDto converteUsuarioToDto(Usuario usuario) {
        return usuarioMapper.toDto(usuario);
    }


    public Usuario converteUsuario(UsuarioDto usuarioDto) {
        return usuarioMapper.toEntity(usuarioDto);
    }



}
