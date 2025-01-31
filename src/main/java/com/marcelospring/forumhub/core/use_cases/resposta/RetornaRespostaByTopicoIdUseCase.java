package com.marcelospring.forumhub.core.use_cases.resposta;

import com.marcelospring.forumhub.core.domain.entities.Resposta;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoByIdUseCase;
import com.marcelospring.forumhub.presentation.dtos.RespostaReturnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetornaRespostaByTopicoIdUseCase {

    private final RetornarTopicoByIdUseCase retornarTopicoByIdUseCase;

    @Autowired
    private ConverterRespostaUseCase converterRespostaUseCase;

    public RetornaRespostaByTopicoIdUseCase(RetornarTopicoByIdUseCase retornarTopicoByIdUseCase) {
        this.retornarTopicoByIdUseCase = retornarTopicoByIdUseCase;
    }

    public List<RespostaReturnDto> retornarRespostaById(Long topicoId) {

        var topico = retornarTopicoByIdUseCase.retornarTopicoById(topicoId);

        List<Resposta> respostaList = topico.getResposta();

        respostaList.forEach(resposta -> {
            if (resposta.isDeleted()) {
                respostaList.remove(resposta);
            }
        });

        respostaList.stream().map(resposta -> converterRespostaUseCase.converterResposta(resposta)).toList();

        return respostaList.stream().map(resposta -> converterRespostaUseCase.converterRespostaReturn(resposta)).toList();
    }
}
