package com.marcelospring.forumhub.infra.security.service;

import com.auth0.jwt.algorithms.Algorithm;
import com.marcelospring.forumhub.core.domain.entities.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${api.security.token.secret")
    private String secret;

    public String generateToken(Usuario usuario) {
        try{
            Algorithm algorithm = Algorithm.ECDSA256();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

}
