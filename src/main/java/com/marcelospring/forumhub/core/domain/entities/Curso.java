package com.marcelospring.forumhub.core.domain.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String categoria;

}
