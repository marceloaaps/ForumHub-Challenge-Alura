package com.marcelospring.forumhub.core.domain.entities;

import jakarta.persistence.*;

@Table(name = "Perfil")
@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
