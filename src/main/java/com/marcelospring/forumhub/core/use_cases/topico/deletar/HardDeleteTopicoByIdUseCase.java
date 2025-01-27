package com.marcelospring.forumhub.core.use_cases.topico.deletar;

import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Deprecated
public class HardDeleteTopicoByIdUseCase {

    private final TopicoRepository topicoRepository;

    public HardDeleteTopicoByIdUseCase(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public ResponseEntity<Void> deletar(Long id) {
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
