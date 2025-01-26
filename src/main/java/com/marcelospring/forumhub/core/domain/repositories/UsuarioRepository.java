package com.marcelospring.forumhub.core.domain.repositories;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioById(Long id);
    UserDetails findByEmail(String email);
    UsuarioDto findDtoUsuarioByEmail(String email);
    UsuarioDto findUsuarioByNome(String nome);
}