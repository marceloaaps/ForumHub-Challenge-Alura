package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.use_cases.topico.deletar.SoftDeleteTopicoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.criar.CriarTopicoUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoDtoByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.topico.retornar.RetornarTopicoUseCase;
import com.marcelospring.forumhub.infra.exceptions.ResourceNotFoundException;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/topicos")
public class TopicoController {

    private final CriarTopicoUseCase criarTopicoUseCase;
    private final RetornarTopicoUseCase retornarTopicoUseCase;
    private final RetornarTopicoDtoByIdUseCase retornarTopicoDtoByIdUseCase;
    private final SoftDeleteTopicoByIdUseCase softDeleteTopicoByIdUseCase;

    public TopicoController(CriarTopicoUseCase criarTopicoUseCase,
                            RetornarTopicoUseCase retornarTopicoUseCase,
                            RetornarTopicoDtoByIdUseCase retornarTopicoDtoByIdUseCase, SoftDeleteTopicoByIdUseCase softDeleteTopicoByIdUseCase
                            ) {

        this.criarTopicoUseCase = criarTopicoUseCase;
        this.retornarTopicoUseCase = retornarTopicoUseCase;
        this.retornarTopicoDtoByIdUseCase = retornarTopicoDtoByIdUseCase;
        this.softDeleteTopicoByIdUseCase = softDeleteTopicoByIdUseCase;
    }


    @Operation(description = "Cria o tópico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",  description = "Retorna código 201 sem body."),
            @ApiResponse(responseCode = "400",  description = "Retorna código 400 Bad Request.")}
    )
    @PostMapping
    public ResponseEntity<Void> criarTopico(@RequestBody @Valid TopicoDto topicoDto) {

        criarTopicoUseCase.criarTopico(topicoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


    @Operation(description = "Retorna todos os tópicos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista todos os tópicos disponíveis.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TopicoDto.class))),
            @ApiResponse(responseCode = "204", description = "Retorna 204 sem body, se não tiver corpo.")
    })
    @GetMapping
    public ResponseEntity<Page<TopicoDto>> getTopicos(Pageable pageable) {
        Page<TopicoDto> page = retornarTopicoUseCase.findAll(pageable);

        if (page.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(page);
    }

    @Operation(description = "Retorna todos os tópicos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",  description = "Retorna código 200 com o corpo atualizado do tópico."),
            @ApiResponse(responseCode = "404",  description = "Retorna código 404 Resource Not Found, caso não encontrado topico.")}
    )
    @GetMapping("/{id}")
    public ResponseEntity<TopicoDto> getTopico(@PathVariable("id") Long id) {

        validaRequest(id);

        var topico =  retornarTopicoDtoByIdUseCase.retornarTopicoDtoById(id);

        if (topico == null) {
            throw new ResourceNotFoundException("Topico de id " + id + "não encontrado.");
        }

        return ResponseEntity.ok(topico);
    }

    @Operation(description = "Atualiza o tópico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",  description = "Retorna código 200 com o corpo atualizado."),
            @ApiResponse(responseCode = "404",  description = "Retorna código 404 Resource Not Found.")}
    )
    @PutMapping("/{id}")
    public ResponseEntity<TopicoDto> atualizarTopico(
            @PathVariable("id") Long id,
            @RequestBody @Valid TopicoDto topicoDto) {

        validaRequest(id);

        var topicoAntigo = retornarTopicoDtoByIdUseCase.retornarTopicoDtoById(id);

        if (topicoAntigo == null) {
            throw new ResourceNotFoundException(topicoDto.titulo());
        }

        criarTopicoUseCase.criarTopico(topicoAntigo);

        return ResponseEntity.ok(topicoDto);
    }

    @Operation(description = "Atualiza o tópico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",  description = "Retorna código 204 no content."),
            @ApiResponse(responseCode = "404",  description = "Retorna código 404 Resource Not Found caso topico não encontrado.")}
    )
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable("id") Long id) {

        validaRequest(id);

        var topicoDto = softDeleteTopicoByIdUseCase.deletarTopico(id);

        if (topicoDto == null) {
            throw new ResourceNotFoundException("Topico de id" + id +  "não encontrado.");
        }

        return ResponseEntity.noContent().build();
    }

    private void validaRequest(Long id){
        if (id == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
