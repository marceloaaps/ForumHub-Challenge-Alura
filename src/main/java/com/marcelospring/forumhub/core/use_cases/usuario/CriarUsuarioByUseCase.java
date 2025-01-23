package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.repositories.UsuarioRepository;
import com.marcelospring.forumhub.infra.exceptions.ExistingEmailException;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public class CriarUsuarioByUseCase {


    private final UsuarioRepository usuarioRepository;

    private final ConverteUsuarioUseCase converteUsuarioUseCase;
    private final VerificaUsuarioByUseCase verificaUsuarioByUseCase;

    public CriarUsuarioByUseCase(UsuarioRepository usuarioRepository, ConverteUsuarioUseCase converteUsuarioUseCase, VerificaUsuarioByUseCase verificaUsuarioByUseCase) {
        this.usuarioRepository = usuarioRepository;
        this.converteUsuarioUseCase = converteUsuarioUseCase;
        this.verificaUsuarioByUseCase = verificaUsuarioByUseCase;
    }

    public void criarUsuario(UsuarioDto usuarioDto){
        verificaUsuarioByUseCase.usuarioExiste(usuarioDto);
        var usuario = converteUsuarioUseCase.converteUsuario(usuarioDto);
        usuarioRepository.save(usuario);
    }
}
