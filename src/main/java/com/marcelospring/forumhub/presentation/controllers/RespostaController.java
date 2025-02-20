package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.use_cases.resposta.AtualizarRespostaByIdUseCase;
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
    private final AtualizarRespostaByIdUseCase atualizarRespostaByIdUseCase;

    public RespostaController(CriarRespostaUseCase criarRespostaUseCase, RetornaRespostaByTopicoIdUseCase retornarRespostaByTopicoIdUseCase, SoftDeleteRespostaByIdUseCase softDeleteRespostaByIdUseCase, AtualizarRespostaByIdUseCase atualizarRespostaByIdUseCase) {
        this.criarRespostaUseCase = criarRespostaUseCase;
        this.retornarRespostaByTopicoIdUseCase = retornarRespostaByTopicoIdUseCase;
        this.softDeleteRespostaByIdUseCase = softDeleteRespostaByIdUseCase;
        this.atualizarRespostaByIdUseCase = atualizarRespostaByIdUseCase;
    }


    @Operation(description = "Cria uma resposta.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",  description = "Retorna código 204 no content.", content = @Content()),
            @ApiResponse(responseCode = "404",
                    description = "Retorna código 404 Resource Not Found caso topico ou usuário não encontrados.", content = @Content()),
            @ApiResponse (responseCode = "401", description = "Caso não autenticado pelo Bearer, retorna 401 Unauthorized.", content = @Content())}
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
            @ApiResponse(responseCode = "204", description = "Retorna 204 sem body, se não tiver corpo.", content = @Content()
            ),
            @ApiResponse (responseCode = "401", description = "Caso não autenticado pelo Bearer, retorna 401 Unauthorized.", content = @Content())

    })
    @GetMapping(value = "/procura-respostas/{id}")
    public ResponseEntity<List<RespostaReturnDto>> getRespostaByTopicoId(@PathVariable("id") Long id) {

        List<RespostaReturnDto> respostaList = retornarRespostaByTopicoIdUseCase.retornarRespostaById(id);

        return ResponseEntity.ok(respostaList);
    }


    @Operation(description = "Deleta a resposta. ID a se passar é id a ser deletado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",  description = "Retorna código 204 no content.", content = @Content()),
            @ApiResponse(responseCode = "404",  description = "Retorna código 404 Resource Not Found caso resposta não encontrada.", content = @Content()),
            @ApiResponse (responseCode = "401", description = "Caso não autenticado pelo Bearer, retorna 401 Unauthorized.", content = @Content())}
    )
    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Void> deletarResposta(@PathVariable("id") Long id) {

        softDeleteRespostaByIdUseCase.deletarRespostaById(id);

        return ResponseEntity.noContent().build();
    }


    @Operation(description = "Atualiza a resposta.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",  description = "Success: Retorna código 204 sem o corpo."),
            @ApiResponse(responseCode = "404",  description = "Error: Retorna código 404 Resource Not Found."),
            @ApiResponse (responseCode = "401", description = "Caso não autenticado pelo Bearer, retorna 401 Unauthorized.")}
    )
    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Void> updateRespostaDto (@PathVariable Long id, @RequestBody @Valid UpdateRespostaDto updateRespostaDto) {

        atualizarRespostaByIdUseCase.atualizarResposta(id, updateRespostaDto);
        validaRequest(id);

        return ResponseEntity.noContent().build();
    }

    private void validaRequest(Long id){
        if (id == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
