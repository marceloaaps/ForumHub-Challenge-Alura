package com.marcelospring.forumhub.core.domain.entities;


import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Topico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> resposta;

    public Topico(Curso curso, Usuario autor, LocalDateTime dataCriacao, String mensagem, List<Resposta> resposta, boolean status, String titulo) {
        this.curso = curso;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
        this.mensagem = mensagem;
        this.resposta = resposta;
        this.status = status;
        this.titulo = titulo;
    }
}
