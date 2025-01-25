package com.marcelospring.forumhub.core.use_cases.topico.verificar;

import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.stereotype.Service;

@Service
public class VerificarTopicoUseCase {

    private final TopicoRepository repository;

    public VerificarTopicoUseCase(TopicoRepository repository) {
        this.repository = repository;
    }

    public boolean verificaTopicoTitulo(TopicoDto topicoDto) {
        return repository.existsByTituloIgnoreCase(topicoDto.titulo());
    }

    public boolean verificaTopicoMensagem(TopicoDto topicoDto) {
        return repository.existsByMensagemIgnoreCase(topicoDto.titulo());
    }



}
