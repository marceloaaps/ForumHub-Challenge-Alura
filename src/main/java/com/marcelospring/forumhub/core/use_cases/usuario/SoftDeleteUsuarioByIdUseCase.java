package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.core.domain.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class SoftDeleteUsuarioByIdUseCase {

    private final RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase;
    private final UsuarioRepository usuarioRepository;

    public SoftDeleteUsuarioByIdUseCase(RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase, UsuarioRepository usuarioRepository) {
        this.retornarUsuarioByIdUseCase = retornarUsuarioByIdUseCase;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario softDeleteUsuarioByIdUseCase(Long id) {

        var usuario = retornarUsuarioByIdUseCase.retornarUsuario(id);

        if (usuario == null) {
            throw new NullPointerException("Usuário de id " + id + "não encontrado");
        }

        usuario.setActive(false);
        usuarioRepository.save(usuario);

        return usuario;
    }
}
