package com.marcelospring.forumhub.core.use_cases.topico.converter;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.use_cases.usuario.ConverteUsuarioUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByIdUseCase;
import com.marcelospring.forumhub.infra.adapters.TopicoMapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverteTopicoUseCase {


    private final TopicoMapper topicoMapper;
    private final ConverteUsuarioUseCase converteUsuarioUseCase;
    private final RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase;

    @Autowired
    public ConverteTopicoUseCase(TopicoMapper topicoMapper, ConverteUsuarioUseCase converteUsuarioUseCase, RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase) {
        this.topicoMapper = topicoMapper;
        this.converteUsuarioUseCase = converteUsuarioUseCase;
        this.retornarUsuarioByIdUseCase = retornarUsuarioByIdUseCase;
    }

    public TopicoDto converteTopicoParaDto(Topico topico) {


        return topicoMapper.toDto(topico);
    }


    // DEVE RECEBER USUARIO E CODE
    public Topico converteTopicoDtoParaTopico(TopicoDto topicoDto) {

        Topico topico =  topicoMapper.toEntity(topicoDto);
        var usuario = retornarUsuarioByIdUseCase.retornarUsuario(topicoDto.autor());
        converteUsuarioUseCase.converteUsuario(usuario);

        topico.setAutor(usuario);


        return topico;
    }

}
