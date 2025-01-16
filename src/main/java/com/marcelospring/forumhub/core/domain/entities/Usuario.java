package com.marcelospring.forumhub.core.domain.entities;

import jakarta.persistence.*;

@Table(name = "Usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @OneToOne
    @JoinColumn(name = "perfil_id", unique = true)
    private Perfil perfis;
}
