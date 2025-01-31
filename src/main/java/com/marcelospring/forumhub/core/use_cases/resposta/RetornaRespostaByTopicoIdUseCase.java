package com.marcelospring.forumhub.core.use_cases.resposta;

import com.marcelospring.forumhub.core.domain.entities.Resposta;
import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.repositories.RespostaRepository;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoByIdUseCase;
import com.marcelospring.forumhub.presentation.dtos.RespostaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetornaRespostaByTopicoIdUseCase {

    private final RespostaRepository respostaRepository;
    private final RetornarTopicoByIdUseCase retornarTopicoByIdUseCase;


    public RetornaRespostaByTopicoIdUseCase(RespostaRepository respostaRepository, RetornarTopicoByIdUseCase retornarTopicoByIdUseCase) {
        this.respostaRepository = respostaRepository;
        this.retornarTopicoByIdUseCase = retornarTopicoByIdUseCase;
    }

    public Resposta retornarRespostaById(Long topicoId) {

        var topico = retornarTopicoByIdUseCase.retornarTopicoById(topicoId);

        List<Resposta> respostaList = topico.getResposta();
        respostaList.forEach(resposta -> System.out.println(resposta.getId() + " " + resposta.getAutor() + " " + resposta.getMensagem()));


        return null;


    }

}
