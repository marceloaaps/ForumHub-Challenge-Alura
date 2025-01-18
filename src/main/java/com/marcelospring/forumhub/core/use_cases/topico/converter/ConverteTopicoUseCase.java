package com.marcelospring.forumhub.core.use_cases.topico.converter;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.infra.adapters.mappers.TopicoMapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.stereotype.Service;

@Service
public class ConverteTopicoUseCase {

    public TopicoDto converteTopicoParaDto(Topico topico) {
        return TopicoMapper.INSTANCE.toDto(topico);
    }
    public Topico converteTopicoParaTopico(TopicoDto topicoDto) {
        return TopicoMapper.INSTANCE.toEntity(topicoDto);
    }
}
