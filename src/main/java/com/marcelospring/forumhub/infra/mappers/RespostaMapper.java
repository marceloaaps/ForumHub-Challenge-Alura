package com.marcelospring.forumhub.infra.mappers;

import com.marcelospring.forumhub.core.domain.entities.Resposta;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.presentation.dtos.RespostaDto;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RespostaMapper {

    RespostaMapper INSTANCE = Mappers.getMapper( RespostaMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "senha", target = "senha")
    Usuario toEntity(RespostaDto respostaDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "senha", target = "senha")
    UsuarioDto toDto(Resposta resposta);
}
