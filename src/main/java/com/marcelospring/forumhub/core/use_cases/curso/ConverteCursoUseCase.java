package com.marcelospring.forumhub.core.use_cases.curso;

import com.marcelospring.forumhub.core.domain.entities.Curso;
import com.marcelospring.forumhub.infra.adapters.mappers.CursoMapper;
import com.marcelospring.forumhub.presentation.dtos.CursoDto;
import org.springframework.stereotype.Service;

@Service
public class ConverteCursoUseCase {

    public CursoDto converteCurso(Curso curso) {
        return CursoMapper.INSTANCE.toDto(curso);
    }

}
