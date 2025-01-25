package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.core.domain.repositories.UsuarioRepository;
import com.marcelospring.forumhub.infra.exceptions.ExistingEmailException;
import com.marcelospring.forumhub.infra.security.service.PasswordEncoder;
import com.marcelospring.forumhub.presentation.dtos.AuthDto;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public class CriarUsuarioByUseCase {


    private final UsuarioRepository usuarioRepository;
    private final ConverteUsuarioUseCase converteUsuarioUseCase;
    private final VerificaUsuarioByUseCase verificaUsuarioByUseCase;
    private final PasswordEncoder passwordEncoder;

    public CriarUsuarioByUseCase(UsuarioRepository usuarioRepository, ConverteUsuarioUseCase converteUsuarioUseCase, VerificaUsuarioByUseCase verificaUsuarioByUseCase, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.converteUsuarioUseCase = converteUsuarioUseCase;
        this.verificaUsuarioByUseCase = verificaUsuarioByUseCase;
        this.passwordEncoder = passwordEncoder;
    }

    public void criarUsuario(AuthDto authDto){


        verificaUsuarioByUseCase.usuarioExiste(authDto.email());
        var usuario = converteUsuarioUseCase.converteUsuarioByAuth(authDto);

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
    }
}
