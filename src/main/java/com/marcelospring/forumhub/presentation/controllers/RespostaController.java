package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.use_cases.resposta.CriarRespostaUseCase;
import com.marcelospring.forumhub.core.use_cases.resposta.RetornaRespostaByTopicoIdUseCase;
import com.marcelospring.forumhub.core.use_cases.resposta.SoftDeleteRespostaByIdUseCase;
import com.marcelospring.forumhub.presentation.dtos.EntradaRespostaDto;
import com.marcelospring.forumhub.presentation.dtos.RespostaReturnDto;
import com.marcelospring.forumhub.presentation.dtos.UpdateRespostaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/respostas")
public class RespostaController {


    private final CriarRespostaUseCase criarRespostaUseCase;
    private final RetornaRespostaByTopicoIdUseCase retornarRespostaByTopicoIdUseCase;
    private final SoftDeleteRespostaByIdUseCase softDeleteRespostaByIdUseCase;

    public RespostaController(CriarRespostaUseCase criarRespostaUseCase, RetornaRespostaByTopicoIdUseCase retornarRespostaByTopicoIdUseCase, SoftDeleteRespostaByIdUseCase softDeleteRespostaByIdUseCase) {
        this.criarRespostaUseCase = criarRespostaUseCase;
        this.retornarRespostaByTopicoIdUseCase = retornarRespostaByTopicoIdUseCase;
        this.softDeleteRespostaByIdUseCase = softDeleteRespostaByIdUseCase;
    }


    @Operation(description = "Cria uma resposta.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",  description = "Retorna código 204 no content."),
            @ApiResponse(responseCode = "404",
                    description = "Retorna código 404 Resource Not Found caso topico ou usuário não encontrados.")}
    )
    @PostMapping(value = "/adicionar-respostas")
    public ResponseEntity<Void> adicionarResposta(@RequestBody @Valid EntradaRespostaDto entradaRespostaDto) {

        criarRespostaUseCase.adicionarResposta(entradaRespostaDto);

        return ResponseEntity.noContent().build();
    }


    @Operation(description = "ID necessário é ID do Tópico. Retorna todas respostas de um certo post.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista todos os tópicos disponíveis.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RespostaReturnDto.class))),
            @ApiResponse(responseCode = "204", description = "Retorna 204 sem body, se não tiver corpo.", content = @Content())
    })
    @GetMapping(value = "/procura-respostas/{id}")
    public ResponseEntity<List<RespostaReturnDto>> getRespostaByTopicoId(@PathVariable("id") Long id) {

        List<RespostaReturnDto> respostaList = retornarRespostaByTopicoIdUseCase.retornarRespostaById(id);

        return ResponseEntity.ok(respostaList);
    }


    @Operation(description = "Deleta a resposta. ID a se passar é id a ser deletado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",  description = "Retorna código 204 no content."),
            @ApiResponse(responseCode = "404",  description = "Retorna código 404 Resource Not Found caso resposta não encontrada.")}
    )
    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Void> deletarResposta(@PathVariable("id") Long id) {

        softDeleteRespostaByIdUseCase.deletarRespostaById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Void> updateRespostaDto (@PathVariable Long id, @RequestBody @Valid UpdateRespostaDto updateRespostaDto) {

        validaRequest(id);




    }

    private void validaRequest(Long id){
        if (id == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
