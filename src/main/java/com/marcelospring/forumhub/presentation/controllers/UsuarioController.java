package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByNomeUseCase;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping(name = "/usuarios")
public class UsuarioController {

    @Autowired
    RetornarUsuarioByNomeUseCase retornarUsuarioByNomeUseCase;

    @GetMapping(name = "/busca-nomes/{nome}")
    public ResponseEntity<UsuarioDto> getUsuarioByName(String nome) {
        var usuario = retornarUsuarioByNomeUseCase.retornaUsuarioByNome(nome);

        return ResponseEntity.ok(usuario);
    }
}
