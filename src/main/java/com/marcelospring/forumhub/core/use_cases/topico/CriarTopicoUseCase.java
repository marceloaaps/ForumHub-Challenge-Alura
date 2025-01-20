package com.marcelospring.forumhub.core.use_cases.topico;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.core.domain.repositories.TopicoRepository;
import com.marcelospring.forumhub.core.use_cases.curso.ConverteCursoUseCase;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingMessageException;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingTitleException;
import com.marcelospring.forumhub.core.use_cases.topico.converter.ConverteTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.verificar.VerificarTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.ConverteUsuarioUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByIdUseCase;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import jakarta.transaction.Transactional;
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

    public void criarTopico(TopicoDto topicoDto) {

        // Verifica se o usuário existe
        UsuarioDto autor = retornarUsuarioByIdUseCase.retornarUsuario(topicoDto.autor());

        if (autor == null) {
            throw new RuntimeException("Usuário inexistente");
        }

        // Converte o DTO para a entidade de Tópico
        var topico = converteTopicoUseCase.converteTopicoDtoParaTopico(topicoDto);

        // Verifica se o título do tópico já existe
        if (verificarTopicoUseCase.verificaTopicoTitulo(topicoDto)) {
            throw new ExistingTitleException(topicoDto.titulo());
        }

        // Verifica se a mensagem do tópico já existe
        if (verificarTopicoUseCase.verificaTopicoMensagem(topicoDto)) {
            throw new ExistingMessageException(topicoDto.mensagem());
        }

        // Define o autor do tópico se ele existe
        topico.setAutor(converteUsuarioUseCase.converteUsuario(autor));

        // Define a data de criação do tópico
        var data = LocalDateTime.now();
        topico.setDataCriacao(data);

        // Salva o tópico no repositório
        repository.save(topico);
    }




}
