package com.marcelospring.forumhub.core.use_cases.topico.retornar;


import com.marcelospring.forumhub.core.use_cases.curso.ConverteCursoUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.ConverteUsuarioUseCase;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.stereotype.Service;

@Service
public class RetornarTopicoDtoByIdUseCase {

    private final RetornarTopicoByIdUseCase retornar;
    private final ConverteUsuarioUseCase converteUsuarioUseCase;
    private final ConverteCursoUseCase converteCursoUseCase;

    public RetornarTopicoDtoByIdUseCase(RetornarTopicoByIdUseCase retornar,
                                        ConverteUsuarioUseCase converteUsuarioUseCase,
                                        ConverteCursoUseCase converteCursoUseCase) {
        this.retornar = retornar;
        this.converteUsuarioUseCase = converteUsuarioUseCase;
        this.converteCursoUseCase = converteCursoUseCase;
    }


    public TopicoDto retornarTopicoDtoById(Long id) {
        var topico = retornar.retornarTopicoById(id);

        if (topico == null) {
            return null;
        }

        var autor = converteUsuarioUseCase.converteUsuario(topico.getAutor());
        var curso = converteCursoUseCase.converteCurso(topico.getCurso());

        return new TopicoDto(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getStatus(),
                autor,
                curso);
    }
}
