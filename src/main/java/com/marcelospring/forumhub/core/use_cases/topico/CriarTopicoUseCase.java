package com.marcelospring.forumhub.core.use_cases.topico;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingMessageException;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingTitleException;
import com.marcelospring.forumhub.core.use_cases.topico.converter.ConverteTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.verificar.VerificarTopicoUseCase;
import com.marcelospring.forumhub.infra.adapters.mappers.TopicoMapper;
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
        this.verificarTopicoUseCase = new VerificarTopicoUseCase();
        this.converteTopicoUseCase = converteTopicoUseCase;
    }

    public void criarTopico(TopicoDto topicoDto) {

        var topico =converteTopicoUseCase.converteTopicoParaTopico(topicoDto);

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

    public TopicoDto criarTopicoDto(TopicoDto topicoDto) {
        Topico topico = TopicoMapper.INSTANCE.toEntity(topicoDto);
        return TopicoMapper.INSTANCE.toDto(repository.save(topico));

    }


}
