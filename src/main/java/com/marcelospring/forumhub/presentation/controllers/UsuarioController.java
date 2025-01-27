package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByNomeUseCase;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/usuarios")
public class UsuarioController {

    @Autowired
    private final RetornarUsuarioByNomeUseCase retornarUsuarioByNomeUseCase;

    public UsuarioController(RetornarUsuarioByNomeUseCase retornarUsuarioByNomeUseCase) {
        this.retornarUsuarioByNomeUseCase = retornarUsuarioByNomeUseCase;
    }

    @GetMapping(name = "/busca-nomes/{nome}")
    public ResponseEntity<UsuarioDto> getUsuarioByName(String nome) {
        var usuario = retornarUsuarioByNomeUseCase.retornaUsuarioByNome(nome);

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping(name = "/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("id") Long id) {


        return null;
    }

}
