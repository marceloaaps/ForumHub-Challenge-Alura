package com.marcelospring.forumhub.core.use_cases.topico;

import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingMessageException;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingTitleException;
import com.marcelospring.forumhub.core.use_cases.topico.converter.ConverteTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.verificar.VerificarTopicoUseCase;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CriarTopicoUseCase {

    private final TopicoRepository repository;
    private final VerificarTopicoUseCase verificarTopicoUseCase;
    private final ConverteTopicoUseCase converteTopicoUseCase;

    public CriarTopicoUseCase(TopicoRepository repository, ConverteTopicoUseCase converteTopicoUseCase) {
        this.repository = repository;
        this.verificarTopicoUseCase = new VerificarTopicoUseCase(repository);
        this.converteTopicoUseCase = converteTopicoUseCase;
    }

    public void criarTopico(TopicoDto topicoDto) {
        System.out.println("Recebendo DTO: {}" + topicoDto);

        var topico = converteTopicoUseCase.converteTopicoDtoParaTopico(topicoDto);

        if (verificarTopicoUseCase.verificaTopicoTitulo(topicoDto)){
            throw new ExistingTitleException(topicoDto.titulo());
        }

        if (verificarTopicoUseCase.verificaTopicoMensagem(topicoDto) ){
            throw new ExistingMessageException((topicoDto.mensagem()));
        }

        var data = LocalDateTime.now();
        topico.setDataCriacao(data);

        repository.save(topico);
    }



}
