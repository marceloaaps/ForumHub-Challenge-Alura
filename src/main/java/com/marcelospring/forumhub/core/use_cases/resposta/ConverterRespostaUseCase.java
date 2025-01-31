package com.marcelospring.forumhub.core.use_cases.resposta;

import com.marcelospring.forumhub.core.domain.entities.Resposta;
import com.marcelospring.forumhub.infra.mappers.RespostaMapper;
import com.marcelospring.forumhub.presentation.dtos.RespostaDto;
import com.marcelospring.forumhub.presentation.dtos.RespostaReturnDto;
import org.springframework.stereotype.Service;

@Service
public class ConverterRespostaUseCase {

    private final RespostaMapper respostaMapper;

    public ConverterRespostaUseCase(RespostaMapper respostaMapper) {
        this.respostaMapper = respostaMapper;
    }

    public RespostaDto converterResposta(Resposta resposta) {
        return respostaMapper.toDto(resposta);
    }

    public RespostaReturnDto converterRespostaReturn(Resposta resposta) {
        return new RespostaReturnDto(resposta.getMensagem(),
                resposta.getTopico().getMensagem(), resposta.getAutor().getNome(), resposta.getDataCriacao());
    }

}
