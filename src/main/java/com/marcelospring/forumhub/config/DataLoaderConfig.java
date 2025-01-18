package com.marcelospring.forumhub.config;

import com.marcelospring.forumhub.core.domain.entities.Perfil;
import com.marcelospring.forumhub.core.domain.repositories.PerfilRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {

    @PersistenceContext
    private EntityManager entityManager;

//    @Bean
//    CommandLineRunner initDatabase(PerfilRepository perfilRepository) {
//        return args -> {
//            perfilRepository.save(new Perfil("Admin"));
//            perfilRepository.save(new Perfil("User"));
//            perfilRepository.save(new Perfil("Guest"));
//        };
//    }





}
