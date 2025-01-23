package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.use_cases.usuario.CriarUsuarioByUseCase;
import com.marcelospring.forumhub.presentation.dtos.UsuarioDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CriarUsuarioByUseCase criarUsuario;


    // Cabe uma criação de metodo para abstracao
    @PostMapping("/login")
    public ResponseEntity login(@RequestParam @Valid UsuarioDto usuarioDto){

        var senhaDoUsuario = new UsernamePasswordAuthenticationToken(usuarioDto.email(), usuarioDto.senha());
        var auth = authenticationManager.authenticate(senhaDoUsuario);

        return ResponseEntity.ok().body(auth);

    }

    @PostMapping("/registrar")
    public ResponseEntity register(@RequestParam @Valid UsuarioDto usuarioDto){

        criarUsuario.criarUsuario(usuarioDto);
        return ResponseEntity.ok().build();
    }

}
