package com.marcelospring.forumhub.core.use_cases.curso;

import com.marcelospring.forumhub.core.domain.entities.Curso;
import com.marcelospring.forumhub.infra.adapters.CursoMapper;
import com.marcelospring.forumhub.presentation.dtos.CursoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverteCursoUseCase {

    private final CursoMapper cursoMapper;

    @Autowired
    public ConverteCursoUseCase(CursoMapper cursoMapper) {
        this.cursoMapper = cursoMapper;
    }


    public CursoDto converteCurso(Curso curso) {
        return cursoMapper.toDto(curso);
    }

}
