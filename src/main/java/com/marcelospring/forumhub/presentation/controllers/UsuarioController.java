package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByNomeUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.SoftDeleteUsuarioByIdUseCase;
import com.marcelospring.forumhub.presentation.dtos.TopicoDto;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/usuarios")
public class UsuarioController {


    private final RetornarUsuarioByNomeUseCase retornarUsuarioByNomeUseCase;

    private final SoftDeleteUsuarioByIdUseCase softDeleteUsuarioByIdUseCase;

    public UsuarioController(RetornarUsuarioByNomeUseCase retornarUsuarioByNomeUseCase, SoftDeleteUsuarioByIdUseCase softDeleteUsuarioByIdUseCase) {
        this.retornarUsuarioByNomeUseCase = retornarUsuarioByNomeUseCase;
        this.softDeleteUsuarioByIdUseCase = softDeleteUsuarioByIdUseCase;
    }

    @Operation(description = "Retorna o usuário com id desejado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o usuário com código 200."),
            @ApiResponse (responseCode = "401", description = "Caso não autenticado pelo Bearer, retorna 401 Unauthorized."),
            @ApiResponse(responseCode = "404",  description = "Error: Retorna código 404 Resource Not Found.")
    })
    @GetMapping("/busca-nomes/{nome}")
    public ResponseEntity<UsuarioDto> getUsuarioByName(String nome) {
        var usuario = retornarUsuarioByNomeUseCase.retornaUsuarioByNome(nome);
        return ResponseEntity.ok(usuario);
    }

    @Operation(description = "Deleta o usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",  description = "Success: Retorna código 204 no content."),
            @ApiResponse(responseCode = "404",  description = "Error: Retorna código 404 Resource Not Found."),
            @ApiResponse (responseCode = "401", description = "Falha de auth: Caso não autenticado pelo Bearer, retorna 401 Unauthorized.")}
    )
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("id") Long id) {
        softDeleteUsuarioByIdUseCase.softDeleteUsuarioByIdUseCase(id);
        return ResponseEntity.noContent().build();
    }
}
