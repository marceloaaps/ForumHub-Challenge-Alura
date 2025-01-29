package com.marcelospring.forumhub.core.use_cases.topico.retornar;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.infra.mappers.TopicoMapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetornarTopicoUseCase {

    private final TopicoRepository topicoRepository;
    private final TopicoMapper topicoMapper;

    public RetornarTopicoUseCase(TopicoRepository topicoRepository, TopicoMapper topicoMapper) {
        this.topicoRepository = topicoRepository;
        this.topicoMapper = topicoMapper;
    }

    public Page<TopicoDto> findAll(Pageable pageable) {


        List<Topico> topicos = topicoRepository.findAll(pageable).getContent();

        if (pageable.getSort().isUnsorted()) {
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").ascending());
        }
        return topicoRepository.findAll(pageable).map(topicoMapper::toDto);
    }
}

