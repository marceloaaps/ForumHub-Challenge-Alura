package com.marcelospring.forumhub.core.use_cases.curso;

import com.marcelospring.forumhub.core.domain.entities.Curso;
import com.marcelospring.forumhub.core.domain.repositories.CursoRepository;
import com.marcelospring.forumhub.presentation.dtos.CursoDto;
import org.springframework.stereotype.Service;

@Service
public class RetornarCursoByIdUseCase {

    private final ConverteCursoUseCase converteCursoUseCase;
    private final CursoRepository cursoRepository;

    public RetornarCursoByIdUseCase(ConverteCursoUseCase converteCurspUseCase, CursoRepository cursoRepository) {
        this.converteCursoUseCase = converteCurspUseCase;
        this.cursoRepository = cursoRepository;
    }

    public CursoDto retornarCurso(Long id) {
        Curso curso = cursoRepository.findCursoById(id);
        return converteCursoUseCase.converteCursoToDto(curso);
    }

}
