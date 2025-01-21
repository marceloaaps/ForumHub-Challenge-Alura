package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.infra.mappers.UsuarioMapper;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverteUsuarioUseCase {

    //ERRO SE ENCONTRA AQUI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    private final UsuarioMapper usuarioMapper;

    @Autowired
    public ConverteUsuarioUseCase(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }


    public UsuarioDto converteUsuarioToDto(Usuario usuario) {
        return usuarioMapper.toDto(usuario);
    }


    //ERRO ESTÁ AQUI!!!!!!!!!!!!!!!
    public Usuario converteUsuario(UsuarioDto usuarioDto) {
        System.out.println("converteUsuario" + usuarioDto);
        System.out.println("converteUsuario" + usuarioDto);
        System.out.println("converteUsuario" + usuarioDto);
        System.out.println("converteUsuario" + usuarioDto);
        return usuarioMapper.toEntity(usuarioDto);
    }

}
