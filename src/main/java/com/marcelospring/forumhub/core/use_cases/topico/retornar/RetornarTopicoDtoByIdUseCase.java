package com.marcelospring.forumhub.core.use_cases.topico.retornar;

import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.stereotype.Service;

@Service
public class RetornarTopicoDtoByIdUseCase {

    private final RetornarTopicoByIdUseCase retornar;

    public RetornarTopicoDtoByIdUseCase(RetornarTopicoByIdUseCase retornar) {
        this.retornar = retornar;
    }

    public TopicoDto retornarTopicoDtoById(Long id) {
        var topico = retornar.retornarTopicoById(id);

        if (topico == null) {
            return null;
        }
        return new TopicoDto(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso().getId());
    }
}
