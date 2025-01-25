package com.marcelospring.forumhub.core.use_cases.usuario;

import com.marcelospring.forumhub.core.domain.repositories.UsuarioRepository;
import com.marcelospring.forumhub.infra.exceptions.ExistingEmailException;
import org.springframework.stereotype.Service;

@Service
public class VerificaUsuarioByUseCase {

    private final UsuarioRepository usuarioRepository;

    public VerificaUsuarioByUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void usuarioExiste(String email) {
        if (usuarioRepository.findDtoUsuarioByEmail(email) != null) {
            try {
                throw new ExistingEmailException("O seguinte email ja existe na nossa database: " + email);
            } catch (ExistingEmailException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
