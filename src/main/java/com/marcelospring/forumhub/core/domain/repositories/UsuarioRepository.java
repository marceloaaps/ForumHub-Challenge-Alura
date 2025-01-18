package com.marcelospring.forumhub.core.domain.repositories;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario getUsuariosById(Long id);
}