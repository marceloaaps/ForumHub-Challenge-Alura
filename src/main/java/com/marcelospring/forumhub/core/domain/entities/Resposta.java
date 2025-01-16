package com.marcelospring.forumhub.core.domain.entities;


import jakarta.persistence.*;

import javax.print.attribute.DateTimeSyntax;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    private String solucao;
}
