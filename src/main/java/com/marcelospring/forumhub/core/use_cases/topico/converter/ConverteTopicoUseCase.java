package com.marcelospring.forumhub.core.use_cases.topico.converter;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.use_cases.curso.ConverteCursoUseCase;
import com.marcelospring.forumhub.core.use_cases.curso.RetornarCursoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.ConverteUsuarioUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByIdUseCase;
import com.marcelospring.forumhub.infra.mappers.TopicoMapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverteTopicoUseCase {


    private final TopicoMapper topicoMapper;
    private final RetornarCursoByIdUseCase retornarCursoByIdUseCase;
    private final ConverteCursoUseCase converteCursoUseCase;
    private final ConverteUsuarioUseCase converteUsuarioUseCase;
    private final RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase;

    @Autowired
    public ConverteTopicoUseCase(TopicoMapper topicoMapper, RetornarCursoByIdUseCase retornarCursoByIdUseCase, ConverteCursoUseCase converteCursoUseCase, ConverteUsuarioUseCase converteUsuarioUseCase, RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase) {
        this.topicoMapper = topicoMapper;
        this.retornarCursoByIdUseCase = retornarCursoByIdUseCase;
        this.converteCursoUseCase = converteCursoUseCase;
        this.converteUsuarioUseCase = converteUsuarioUseCase;
        this.retornarUsuarioByIdUseCase = retornarUsuarioByIdUseCase;
    }

    public TopicoDto converteTopicoParaDto(Topico topico) {
        return topicoMapper.toDto(topico);
    }


    public Topico converteTopicoDtoParaTopico(TopicoDto topicoDto) {

        Topico topico =  topicoMapper.toEntity(topicoDto);

        var curso = retornarCursoByIdUseCase.retornarCurso(topicoDto.curso());
        var usuario = retornarUsuarioByIdUseCase.retornarUsuarioDto(topicoDto.autor());

        topico.setAutor(converteUsuarioUseCase.converteUsuario(usuario));
        topico.setCurso(converteCursoUseCase.converteDtoToCurso(curso));

        return topico;
    }

}
