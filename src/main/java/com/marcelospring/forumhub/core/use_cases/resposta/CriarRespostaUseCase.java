package com.marcelospring.forumhub.core.use_cases.resposta;

import com.marcelospring.forumhub.core.domain.repositories.RespostaRepository;
import com.marcelospring.forumhub.presentation.dtos.RespostaDto;
import org.springframework.stereotype.Service;

@Service
public class CriarRespostaUseCase {

    private final RespostaRepository respostaRepository;

    public CriarRespostaUseCase(RespostaRepository respostaRepository) {
        this.respostaRepository = respostaRepository;
    }

    public void adicionarResposta(RespostaDto respostaDto) {



    }

}
