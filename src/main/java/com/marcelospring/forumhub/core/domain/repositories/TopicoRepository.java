package com.marcelospring.forumhub.core.domain.repositories;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloIgnoreCase(String titulo);
    boolean existsByMensagemIgnoreCase(String titulo);
    Page<TopicoDto> findAllByOrderByDataCriacaoDesc(Pageable pageable);
}
