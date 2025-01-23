package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.repositories.UsuarioRepository;
import com.marcelospring.forumhub.infra.exceptions.ExistingEmailException;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public class VerificaUsuarioByUseCase {

    private UsuarioRepository usuarioRepository;

    public void usuarioExiste(UsuarioDto usuarioDto) {
        if (usuarioRepository.findDtoUsuarioByEmail(usuarioDto.email())!=null) {
            try {
                throw new ExistingEmailException(usuarioDto.email());
            } catch (ExistingEmailException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
