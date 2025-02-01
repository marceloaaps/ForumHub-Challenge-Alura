package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.repositories.UsuarioRepository;
import com.marcelospring.forumhub.infra.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SoftDeleteUsuarioByIdUseCase {

    private final RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase;
    private final UsuarioRepository usuarioRepository;

    public SoftDeleteUsuarioByIdUseCase(RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase, UsuarioRepository usuarioRepository) {
        this.retornarUsuarioByIdUseCase = retornarUsuarioByIdUseCase;
        this.usuarioRepository = usuarioRepository;
    }

    public void softDeleteUsuarioByIdUseCase(Long id) {

        var usuario = retornarUsuarioByIdUseCase.retornarUsuario(id);

        if (usuario == null || usuario.isDeleted()) {
            throw new ResourceNotFoundException("Usuário de id " + id + "não encontrado");
        }

        usuario.setDeleted(false);
        usuarioRepository.save(usuario);

    }
}
