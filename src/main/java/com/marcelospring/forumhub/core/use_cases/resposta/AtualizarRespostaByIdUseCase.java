package com.marcelospring.forumhub.core.use_cases.resposta;

import com.marcelospring.forumhub.core.domain.repositories.RespostaRepository;
import com.marcelospring.forumhub.infra.exceptions.ResourceNotFoundException;
import com.marcelospring.forumhub.presentation.dtos.UpdateRespostaDto;
import org.springframework.stereotype.Service;

@Service
public class AtualizarRespostaByIdUseCase {

    private final RespostaRepository respostaRepository;

    public AtualizarRespostaByIdUseCase(RespostaRepository respostaRepository) {
        this.respostaRepository = respostaRepository;
    }

    public void atualizarResposta (Long id, UpdateRespostaDto updateRespostaDto) {

        if (updateRespostaDto.mensagem().isEmpty()){
            throw new ResourceNotFoundException("Mensagem inexistente.");
        }

        var resposta = respostaRepository.getRespostaById(id);

        resposta.setMensagem(updateRespostaDto.mensagem());

        respostaRepository.save(resposta);
    }
}
