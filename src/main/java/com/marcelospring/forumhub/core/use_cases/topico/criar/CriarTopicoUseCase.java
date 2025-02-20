package com.marcelospring.forumhub.core.use_cases.topico.criar;

import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingMessageException;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingTitleException;
import com.marcelospring.forumhub.core.use_cases.topico.converter.ConverteTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.verificar.VerificarTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.ConverteUsuarioUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByIdUseCase;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CriarTopicoUseCase {

    private final TopicoRepository repository;
    private final RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase;
    private final VerificarTopicoUseCase verificarTopicoUseCase;
    private final ConverteTopicoUseCase converteTopicoUseCase;
    private final ConverteUsuarioUseCase converteUsuarioUseCase;

    public CriarTopicoUseCase(TopicoRepository repository, RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase, ConverteTopicoUseCase converteTopicoUseCase, ConverteUsuarioUseCase converteUsuarioUseCase) {
        this.repository = repository;
        this.verificarTopicoUseCase = new VerificarTopicoUseCase(repository);
        this.retornarUsuarioByIdUseCase = retornarUsuarioByIdUseCase;
        this.converteTopicoUseCase = converteTopicoUseCase;
        this.converteUsuarioUseCase = converteUsuarioUseCase;
    }

    //Cabe uma refatoração para abstração aqui.
    public void criarTopico(TopicoDto topicoDto) {

        UsuarioDto autor = retornarUsuarioByIdUseCase.retornarUsuarioDto(topicoDto.autor());
        System.out.println("\nAutor Começo do criarTopico: " + autor);

        if (autor == null) {
            throw new RuntimeException("Usuário inexistente");
        }

        var topico = converteTopicoUseCase.converteTopicoDtoParaTopico(topicoDto);

        if (verificarTopicoUseCase.verificaTopicoTitulo(topicoDto)) {
            throw new ExistingTitleException(topicoDto.titulo());
        }

        if (verificarTopicoUseCase.verificaTopicoMensagem(topicoDto)) {
            throw new ExistingMessageException(topicoDto.mensagem());
        }

        topico.setAutor(converteUsuarioUseCase.converteUsuario(autor));

        var data = LocalDateTime.now();
        topico.setDataCriacao(data);

        repository.save(topico);
    }




}
