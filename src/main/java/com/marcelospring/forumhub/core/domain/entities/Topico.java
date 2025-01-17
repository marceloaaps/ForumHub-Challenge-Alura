package com.marcelospring.forumhub.core.domain.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Topico")
@NoArgsConstructor
@AllArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @NotBlank
    private String titulo;
    @NotBlank
    private String mensagem;
    @NotNull
    private LocalDateTime dataCriacao;
    @NotNull
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @NotNull
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @NotNull
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> resposta;

}
