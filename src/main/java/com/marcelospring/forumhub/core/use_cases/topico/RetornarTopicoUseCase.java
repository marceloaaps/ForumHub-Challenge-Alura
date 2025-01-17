package com.marcelospring.forumhub.core.use_cases.topico;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RetornarTopicoUseCase {

    private TopicoRepository repository;
    public RetornarTopicoUseCase(TopicoRepository repository) {
        this.repository = repository;
    }

    public Page<Topico> findAllByOrderByDataCriacaoDesc() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("dataCriacao")));
        return repository.findAll(pageable);
    }

}
