package com.marcelospring.forumhub.core.use_cases.topico;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.infra.adapters.mappers.TopicoMapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CriarTopicoUseCase {

    private TopicoRepository repository;

    public CriarTopicoUseCase(TopicoRepository repository) {
        this.repository = repository;
    }

    public Topico criarTopico(TopicoDto topicoDto) {


        Topico topico = TopicoMapper.INSTANCE.toEntity(topicoDto);
        var data = LocalDateTime.now();
        topico.setDataCriacao(data);

        repository.save(topico);

        return topico;
    }


}
