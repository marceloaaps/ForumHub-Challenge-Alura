package com.marcelospring.forumhub.presentation.controllers;

import com.marcelospring.forumhub.core.domain.entities.Usuario;
import com.marcelospring.forumhub.core.use_cases.usuario.CriarUsuarioByUseCase;
import com.marcelospring.forumhub.infra.exceptions.CantProcessException;
import com.marcelospring.forumhub.infra.exceptions.InvalidCredentialException;
import com.marcelospring.forumhub.infra.security.service.TokenService;
import com.marcelospring.forumhub.presentation.dtos.AuthDto;
import com.marcelospring.forumhub.presentation.dtos.LoginDto;
import com.marcelospring.forumhub.presentation.dtos.LoginResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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

    @Operation(description = "Registra o usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna código 200 com o body do token."),
            @ApiResponse(responseCode = "401", description = "Retorna código 401 Unathorized.")}
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginDto loginDto) {
        try {
            var senhaDoUsuario = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.senha());
            var auth = this.authenticationManager.authenticate(senhaDoUsuario);

            var token = tokenService.generateToken((Usuario) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDto(token));

        } catch (BadCredentialsException e) {
            throw new InvalidCredentialException(e.getMessage());
        }
        catch (CantProcessException e) {
            throw new CantProcessException(e.getMessage());
        }
    }

    @Operation(description = "Registra o usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna código 201 sem body."),
            @ApiResponse(responseCode = "400", description = "Retorna código 400 Bad Request.")}
    )
    @PostMapping("/registrar")
    public ResponseEntity<Void> register(@RequestBody @Valid AuthDto authDto) {
        criarUsuario.criarUsuario(authDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
