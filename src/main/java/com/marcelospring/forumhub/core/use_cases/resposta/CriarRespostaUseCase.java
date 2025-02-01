package com.marcelospring.forumhub.core.use_cases.resposta;

import com.marcelospring.forumhub.core.domain.entities.Resposta;
import com.marcelospring.forumhub.core.domain.repositories.RespostaRepository;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByIdUseCase;
import com.marcelospring.forumhub.infra.exceptions.ResourceNotFoundException;
import com.marcelospring.forumhub.presentation.dtos.EntradaRespostaDto;
import jakarta.validation.constraints.NotNull;
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

    public void adicionarResposta(@NotNull EntradaRespostaDto entradaRespostaDto) {

        var topico = retornarTopicoByIdUseCase.retornarTopicoById(entradaRespostaDto.topicoId());
        var autor =  retornarUsuarioByIdUseCase.retornarUsuario(entradaRespostaDto.autorId());


        if (topico.isDeleted() || autor.isDeleted()) {
            throw new ResourceNotFoundException("Tópico ou autor inexistente");
        }



        var horaCriacao = LocalDateTime.now();



        var resposta = new Resposta(entradaRespostaDto.mensagem(), horaCriacao, topico, autor);


        System.out.println(resposta.getMensagem());
        System.out.println(resposta.getMensagem());
        System.out.println(resposta.getMensagem());
        System.out.println(resposta.getMensagem());
        System.out.println(resposta.getMensagem());

        respostaRepository.save(resposta);
    }

}
