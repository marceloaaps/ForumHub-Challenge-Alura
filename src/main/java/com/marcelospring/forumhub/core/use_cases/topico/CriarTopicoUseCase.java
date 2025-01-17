package com.marcelospring.forumhub.core.use_cases.topico;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingMessageException;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingTitleException;
import com.marcelospring.forumhub.infra.adapters.mappers.TopicoMapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CriarTopicoUseCase {

    private final TopicoRepository repository;
    private final VerificarTopicoUseCase verificarTopicoUseCase;

    public CriarTopicoUseCase(TopicoRepository repository) {
        this.repository = repository;
        this.verificarTopicoUseCase = new VerificarTopicoUseCase();
    }

    public void criarTopico(TopicoDto topicoDto) {

        Topico topico = TopicoMapper.INSTANCE.toEntity(topicoDto);

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
