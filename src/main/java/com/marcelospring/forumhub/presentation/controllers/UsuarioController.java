package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByNomeUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.SoftDeleteUsuarioByIdUseCase;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
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

    @GetMapping(name = "/busca-nomes/{nome}")
    public ResponseEntity<UsuarioDto> getUsuarioByName(String nome) {
        var usuario = retornarUsuarioByNomeUseCase.retornaUsuarioByNome(nome);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping(name = "/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("id") Long id) {
        softDeleteUsuarioByIdUseCase.softDeleteUsuarioByIdUseCase(id);
        return ResponseEntity.noContent().build();
    }
}
