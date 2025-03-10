package com.marcelospring.forumhub.core.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Resposta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Resposta(String mensagem, LocalDateTime dataCriacao, Topico topico, Usuario autor) {
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.topico = topico;
        this.autor = autor;
        this.isDeleted = false;
    }
}
