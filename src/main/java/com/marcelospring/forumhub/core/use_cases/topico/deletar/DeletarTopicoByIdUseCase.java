package com.marcelospring.forumhub.core.use_cases.topico.deletar;

import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeletarTopicoByIdUseCase {

    private final TopicoRepository topicoRepository;

    public DeletarTopicoByIdUseCase(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public ResponseEntity<Void> deletar(Long id) {

        topicoRepository.deleteById(id);

        return ResponseEntity.ok().build();


    }
}
