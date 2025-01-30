package com.marcelospring.forumhub.core.use_cases.topico.retornar;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.infra.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RetornarTopicoByIdUseCase {

    private final TopicoRepository repository;
    private final TopicoRepository topicoRepository;

    public RetornarTopicoByIdUseCase(TopicoRepository repository, TopicoRepository topicoRepository) {
        this.repository = repository;
        this.topicoRepository = topicoRepository;
    }

    public Topico retornarTopicoById(Long id) {

        if (topicoRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Não existe tópico de id: " + id);
        }

        return repository.getTopicoById(id);
    }

}
