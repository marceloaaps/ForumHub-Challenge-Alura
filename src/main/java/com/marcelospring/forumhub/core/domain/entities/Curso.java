package com.marcelospring.forumhub.core.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "Curso")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
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
