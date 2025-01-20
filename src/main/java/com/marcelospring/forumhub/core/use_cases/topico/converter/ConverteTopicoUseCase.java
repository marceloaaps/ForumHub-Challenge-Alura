package com.marcelospring.forumhub.core.use_cases.topico.converter;

import com.marcelospring.forumhub.core.domain.entities.Topico;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.core.domain.repositories.CursoRepository;
import com.marcelospring.forumhub.core.domain.repositories.UsuarioRepository;
import com.marcelospring.forumhub.infra.adapters.TopicoMapper;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverteTopicoUseCase {


    private final TopicoMapper topicoMapper;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    @Autowired
    public ConverteTopicoUseCase(TopicoMapper topicoMapper, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoMapper = topicoMapper;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    public TopicoDto converteTopicoParaDto(Topico topico) {


        return topicoMapper.toDto(topico);
    }

    public Topico converteTopicoDtoParaTopico(TopicoDto topicoDto) {

        Topico topico =  topicoMapper.toEntity(topicoDto);
        var usuario = usuarioRepository.findUsuarioById(topicoDto.autorDtoId());
        var curso = cursoRepository.findCursoById(topicoDto.curso());

        topico.setAutor(usuario);
        topico.setCurso(curso);

        return topico;
    }

}
