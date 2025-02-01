package com.marcelospring.forumhub.core.domain.repositories;

import com.marcelospring.forumhub.core.domain.entities.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    Resposta getRespostaById(Long id);
}