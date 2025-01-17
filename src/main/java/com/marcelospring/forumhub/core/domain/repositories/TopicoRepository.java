package com.marcelospring.forumhub.core.domain.repositories;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloIgnoreCase(@NotBlank String titulo);

    boolean existsByMensagemIgnoreCase(@NotBlank String titulo);
}
