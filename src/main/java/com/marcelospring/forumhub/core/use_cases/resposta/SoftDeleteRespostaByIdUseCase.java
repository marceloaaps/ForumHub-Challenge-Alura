package com.marcelospring.forumhub.core.use_cases.resposta;

import com.marcelospring.forumhub.core.domain.repositories.RespostaRepository;
import com.marcelospring.forumhub.infra.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SoftDeleteRespostaByIdUseCase {

    private final RespostaRepository respostaRepository;

    public SoftDeleteRespostaByIdUseCase(RespostaRepository respostaRepository) {
        this.respostaRepository = respostaRepository;
    }


    public void deletarRespostaById(Long id) {

        var resposta = respostaRepository.findById(id).orElse(null);

        if (resposta == null || resposta.isDeleted()) {
            throw new ResourceNotFoundException("Id a deletar não encontrado");
        }

        resposta.setDeleted(true);
        respostaRepository.save(resposta);

    }

}
