package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.core.use_cases.usuario.CriarUsuarioByUseCase;
import com.marcelospring.forumhub.infra.security.service.TokenService;
import com.marcelospring.forumhub.presentation.dtos.AuthDto;
import com.marcelospring.forumhub.presentation.dtos.LoginDto;
import com.marcelospring.forumhub.presentation.dtos.LoginResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CriarUsuarioByUseCase criarUsuario;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginDto loginDto){

        var senhaDoUsuario = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.senha());
        var auth = this.authenticationManager.authenticate(senhaDoUsuario);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> register(@RequestBody @Valid AuthDto authDto){
        criarUsuario.criarUsuario(authDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
