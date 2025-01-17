package com.marcelospring.forumhub.core.use_cases.topico;

import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarTopicoUseCase {

    @Autowired
    private TopicoRepository repository;
}
