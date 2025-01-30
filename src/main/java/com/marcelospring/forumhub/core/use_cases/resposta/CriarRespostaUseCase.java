package com.marcelospring.forumhub.core.use_cases.resposta;

import com.marcelospring.forumhub.core.domain.entities.Resposta;
import com.marcelospring.forumhub.core.domain.repositories.RespostaRepository;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByIdUseCase;
import com.marcelospring.forumhub.presentation.dtos.EntradaRespostaDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CriarRespostaUseCase {

    private final RespostaRepository respostaRepository;
    private final RetornarTopicoByIdUseCase retornarTopicoByIdUseCase;
    private final RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase;

    public CriarRespostaUseCase(RespostaRepository respostaRepository, RetornarTopicoByIdUseCase retornarTopicoByIdUseCase, RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase) {
        this.respostaRepository = respostaRepository;
        this.retornarTopicoByIdUseCase = retornarTopicoByIdUseCase;
        this.retornarUsuarioByIdUseCase = retornarUsuarioByIdUseCase;
    }

    public void adicionarResposta(EntradaRespostaDto entradaRespostaDto) {

        var topico = retornarTopicoByIdUseCase.retornarTopicoById(entradaRespostaDto.topicoId());
        var autor =  retornarUsuarioByIdUseCase.retornarUsuario(entradaRespostaDto.autorId());

        var horaCriacao = LocalDateTime.now();

        var resposta = new Resposta(entradaRespostaDto.message(), horaCriacao, topico, autor);

        respostaRepository.save(resposta);
    }

}
