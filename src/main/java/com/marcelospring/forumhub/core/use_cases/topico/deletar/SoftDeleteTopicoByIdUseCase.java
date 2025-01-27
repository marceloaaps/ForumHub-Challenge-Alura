package com.marcelospring.forumhub.core.use_cases.topico.deletar;

import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoByIdUseCase;
import org.springframework.stereotype.Service;

@Service
public class SoftDeleteTopicoByIdUseCase {


    private final RetornarTopicoByIdUseCase retornarTopicoByIdUseCase;
    private final TopicoRepository topicoRepository;

    public SoftDeleteTopicoByIdUseCase(RetornarTopicoByIdUseCase retornarTopicoByIdUseCase, TopicoRepository topicoRepository) {
        this.retornarTopicoByIdUseCase = retornarTopicoByIdUseCase;
        this.topicoRepository = topicoRepository;
    }

    public void deletarTopico(Long id) {

        var topico = retornarTopicoByIdUseCase.retornarTopicoById(id);
        topico.setIs_deleted(true);

        topicoRepository.save(topico);

    }

}
