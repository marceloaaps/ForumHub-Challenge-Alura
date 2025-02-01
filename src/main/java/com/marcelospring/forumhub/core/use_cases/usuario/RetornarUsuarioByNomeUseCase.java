package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.repositories.UsuarioRepository;
import com.marcelospring.forumhub.infra.exceptions.ResourceNotFoundException;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public class RetornarUsuarioByNomeUseCase {

    private final UsuarioRepository usuarioRepository;

    public RetornarUsuarioByNomeUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto retornaUsuarioByNome(String nome) {

        var usuario = usuarioRepository.findUsuarioByNome(nome);

        if (usuario == null) {
            throw new ResourceNotFoundException("Usuário com nome " + nome + "não encontrado");
        }

        return usuario;
    }

}
