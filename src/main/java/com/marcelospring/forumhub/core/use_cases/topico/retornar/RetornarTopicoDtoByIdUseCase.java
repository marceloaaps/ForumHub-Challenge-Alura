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



    //NAO ESTÁ CHEGANDO AQUI!!!!
    public TopicoDto retornarTopicoDtoById(Long id) {
        var topico = retornar.retornarTopicoById(id);

        if (topico == null) {
            return null;
        }

        System.out.println("RetornarTopicoDtoById: " + topico);
        System.out.println("RetornarTopicoDtoById: " + topico);
        System.out.println("RetornarTopicoDtoById: " + topico);
        System.out.println("RetornarTopicoDtoById: " + topico);



        return new TopicoDto(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso());
    }
}
