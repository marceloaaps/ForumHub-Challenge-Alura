package com.marcelospring.forumhub.infra.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Usuario usuario) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create().withIssuer("auth-api")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
            return token;
            
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro na geração do token", exception);
        }
    }


    public String validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            return "";
        }
    }

    private Instant getExpirationDate() {
        return LocalDateTime.now().plusHours(72).toInstant(ZoneOffset.of("-3"));
    }

}
