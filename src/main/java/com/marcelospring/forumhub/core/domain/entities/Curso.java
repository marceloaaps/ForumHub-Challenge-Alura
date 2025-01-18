package com.marcelospring.forumhub.core.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Curso")
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String categoria;

    public Curso(String nome, String tipo) {
        this.name = nome;
        this.categoria = tipo;
    }

}
