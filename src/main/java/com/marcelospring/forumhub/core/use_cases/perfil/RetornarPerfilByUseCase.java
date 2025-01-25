package com.marcelospring.forumhub.core.use_cases.perfil;

import com.marcelospring.forumhub.core.domain.entities.Perfil;
import com.marcelospring.forumhub.core.domain.repositories.PerfilRepository;
import org.springframework.stereotype.Service;

@Service
public class RetornarPerfilByUseCase {

    private final PerfilRepository perfilRepository;

    public RetornarPerfilByUseCase(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public Perfil retornarPerfil(Long perfilId) {

        if (!perfilRepository.existsById(perfilId)) {
            throw new NullPointerException("Perfil inexistente na nossa database: " + perfilId);
        }
        return perfilRepository.getPerfilById(perfilId);

    }

}
