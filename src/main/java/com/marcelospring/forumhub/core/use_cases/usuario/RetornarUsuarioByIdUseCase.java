package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.core.domain.repositories.UsuarioRepository;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public class RetornarUsuarioByIdUseCase {

    private final UsuarioRepository usuarioRepository;
    private final ConverteUsuarioUseCase converteUsuarioUseCase;

    public RetornarUsuarioByIdUseCase(UsuarioRepository usuarioRepository, ConverteUsuarioUseCase converteUsuarioUseCase) {
        this.usuarioRepository = usuarioRepository;
        this.converteUsuarioUseCase = converteUsuarioUseCase;
    }


    public UsuarioDto retornarUsuario(Long id) {


        if (usuarioRepository.findById(id).isEmpty()) {
            throw new NullPointerException("Não existe usuario com id " + id);
        }

        Usuario usuario = usuarioRepository.findUsuarioById(id);
        System.out.println("Usaurio no retornarUsuario"+usuario);

        System.out.println("Usuario em retornarUsuario: " + usuario);
        return converteUsuarioUseCase.converteUsuarioToDto(usuario);


    }
}
