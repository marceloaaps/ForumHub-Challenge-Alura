package com.marcelospring.forumhub.core.use_cases.topico.converter;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.infra.adapters.TopicoMapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverteTopicoUseCase {


    private final TopicoMapper topicoMapper;

    @Autowired
    public ConverteTopicoUseCase(TopicoMapper topicoMapper) {
        this.topicoMapper = topicoMapper;
    }

    public TopicoDto converteTopicoParaDto(Topico topico) {
        return topicoMapper.toDto(topico);
    }

    public Topico converteTopicoDtoParaTopico(TopicoDto topicoDto) {
        return topicoMapper.toEntity(topicoDto);
    }
}
