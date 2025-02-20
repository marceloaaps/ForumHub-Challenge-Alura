package com.marcelospring.forumhub.core.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Topico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private boolean status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> resposta;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Topico(Curso curso, Usuario autor, LocalDateTime dataCriacao, String mensagem, List<Resposta> resposta, boolean status, String titulo) {
        this.curso = curso;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
        this.mensagem = mensagem;
        this.resposta = resposta;
        this.status = status;
        this.titulo = titulo;
        this.isDeleted= false;
    }

    // Por algum MISTERIO DIVINO o lombok não está pegando esse setter
    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<Resposta> getResposta() {
        return resposta;
    }

    public void setResposta(List<Resposta> resposta) {
        this.resposta = resposta;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setisDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
