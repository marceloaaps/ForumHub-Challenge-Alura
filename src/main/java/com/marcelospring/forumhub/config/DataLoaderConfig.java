package com.marcelospring.forumhub.config;

import com.marcelospring.forumhub.core.domain.entities.Perfil;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.core.domain.repositories.PerfilRepository;
import com.marcelospring.forumhub.core.domain.repositories.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    CommandLineRunner initDatabase(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository) {
        return args -> {

//            inserePerfil("Admin");

//            usuarioRepository.save(new Usuario("Joao Frango", "joao@frango.com", "123456"));


        };
    }

    private void inserePerfil(String nomePerfil){
        perfilRepository.save(new Perfil(nomePerfil));
    }

    private void insereUsuario(String nome, String email, String senha){
        usuarioRepository.save(new Usuario(nome, email, senha));
    }





}
