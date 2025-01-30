package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.use_cases.resposta.CriarRespostaUseCase;
import com.marcelospring.forumhub.presentation.dtos.EntradaRespostaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/respostas")
public class RespostaController {


    private final CriarRespostaUseCase criarRespostaUseCase;

    public RespostaController(CriarRespostaUseCase criarRespostaUseCase) {
        this.criarRespostaUseCase = criarRespostaUseCase;
    }

    @Operation(description = "Cria uma resposta.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",  description = "Retorna código 204 no content."),
            @ApiResponse(responseCode = "404",
                    description = "Retorna código 404 Resource Not Found caso topico ou usuário não encontrados.")}
    )
    @PostMapping(value = "/adicionar-resposta")
    public ResponseEntity<Void> adicionarResposta(@RequestBody @Valid EntradaRespostaDto entradaRespostaDto) {

        criarRespostaUseCase.adicionarResposta(entradaRespostaDto);

        return ResponseEntity.noContent().build();

    }
}
