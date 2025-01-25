package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.core.use_cases.perfil.RetornarPerfilByUseCase;
import com.marcelospring.forumhub.infra.mappers.UsuarioMapper;
import com.marcelospring.forumhub.presentation.dtos.AuthDto;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverteUsuarioUseCase {

    private final UsuarioMapper usuarioMapper;
    private final RetornarPerfilByUseCase retornarPerfilByUseCase;

    @Autowired
    public ConverteUsuarioUseCase(UsuarioMapper usuarioMapper, RetornarPerfilByUseCase retornarPerfilByUseCase) {
        this.usuarioMapper = usuarioMapper;
        this.retornarPerfilByUseCase = retornarPerfilByUseCase;
    }

    public Usuario converteUsuarioByAuth(AuthDto authDto) {
        var authRole = retornarPerfilByUseCase.retornarPerfil(authDto.role());
        return new Usuario(authDto.nome(), authDto.email(), authDto.senha(), authRole);

    }

    public UsuarioDto converteUsuarioToDto(Usuario usuario) {
        return usuarioMapper.toDto(usuario);
    }


    public Usuario converteUsuario(UsuarioDto usuarioDto) {
        return usuarioMapper.toEntity(usuarioDto);
    }



}
