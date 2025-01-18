package com.marcelospring.forumhub.core.use_cases.topico.retornar;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import org.springframework.stereotype.Service;

@Service
public class RetornarTopicoByIdUseCase {

    private TopicoRepository repository;

    public RetornarTopicoByIdUseCase(TopicoRepository repository) {
        this.repository = repository;
    }

    public Topico retornarTopicoById(Long id) {
        return repository.getReferenceById(id);
    }

}
