package com.marcelospring.forumhub.config;

import com.marcelospring.forumhub.core.domain.entities.Curso;
import com.marcelospring.forumhub.core.domain.entities.Perfil;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.core.domain.repositories.CursoRepository;
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
    @Autowired
    private CursoRepository cursoRepository;

    @Bean
    CommandLineRunner initDatabase(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository) {
        return args -> {

//            inserePerfil("Admin");

            insereUsuario("Giga Chad", "cortinas@gavia1.com", "123456", perfilRepository.getPerfilById(1L));

//            insereCurso("Curso de Crochê", "Classe 1");


        };
    }

    private void inserePerfil(String nomePerfil) {
        perfilRepository.save(new Perfil(nomePerfil));
    }

    private void insereUsuario(String nome, String email, String senha, Perfil perfil) {
        usuarioRepository.save(new Usuario(nome, email, senha, perfil));
    }

    private void insereCurso(String nome, String tipo) {
        cursoRepository.save(new Curso(nome, tipo));
    }


}
