package com.marcelospring.forumhub.infra.mappers;

import com.marcelospring.forumhub.core.domain.entities.Resposta;
import com.marcelospring.forumhub.presentation.dtos.RespostaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RespostaMapper {

    RespostaMapper INSTANCE = Mappers.getMapper( RespostaMapper.class );

    @Mapping(source = "mensagem", target = "mensagem")
    @Mapping(source = "topico", target = "topico")
    @Mapping(source = "autor", target = "autor")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    Resposta toEntity( RespostaDto respostaDto );

    @Mapping(source = "mensagem", target = "mensagem")
    @Mapping(source = "topico", target = "topico")
    @Mapping(source = "autor", target = "autor")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    RespostaDto toDto( Resposta resposta );



}
