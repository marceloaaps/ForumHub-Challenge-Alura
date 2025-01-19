package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.infra.adapters.UsuarioMapper;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public class ConverteUsuarioUseCase {

    public UsuarioDto converteUsuario(Usuario usuario) {
        return UsuarioMapper.INSTANCE.toDto(usuario);
    }

}
