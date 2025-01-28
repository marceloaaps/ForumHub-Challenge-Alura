package com.marcelospring.forumhub.core.use_cases.topico.deletar;

import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.core.use_cases.topico.converter.ConverteTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoByIdUseCase;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.stereotype.Service;

@Service
public class SoftDeleteTopicoByIdUseCase {

    private final RetornarTopicoByIdUseCase retornarTopicoByIdUseCase;
    private final TopicoRepository topicoRepository;
    private final ConverteTopicoUseCase converteTopicoUseCase;

    public SoftDeleteTopicoByIdUseCase(RetornarTopicoByIdUseCase retornarTopicoByIdUseCase, TopicoRepository topicoRepository, ConverteTopicoUseCase converteTopicoUseCase) {
        this.retornarTopicoByIdUseCase = retornarTopicoByIdUseCase;
        this.topicoRepository = topicoRepository;
        this.converteTopicoUseCase = converteTopicoUseCase;
    }

    public TopicoDto deletarTopico(Long id) {

        if (!topicoRepository.existsById(id)) {
            return null;
        }

        var topico = retornarTopicoByIdUseCase.retornarTopicoById(id);

        topico.setIs_deleted(true);

        topicoRepository.save(topico);

        return converteTopicoUseCase.converteTopicoParaDto(topico);
    }
}
