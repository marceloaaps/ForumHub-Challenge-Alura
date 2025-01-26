package com.marcelospring.forumhub.infra.security.configurations;

import com.marcelospring.forumhub.core.use_cases.usuario.RetornarUsuarioByIdUseCase;
import com.marcelospring.forumhub.core.use_cases.usuario.VerificaUsuarioByUseCase;
import com.marcelospring.forumhub.infra.security.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final VerificaUsuarioByUseCase verificaUsuarioByUseCase;
    private final RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase;

    public SecurityFilter(TokenService tokenService, VerificaUsuarioByUseCase verificaUsuarioByUseCase, RetornarUsuarioByIdUseCase retornarUsuarioByIdUseCase) {
        this.tokenService = tokenService;
        this.verificaUsuarioByUseCase = verificaUsuarioByUseCase;
        this.retornarUsuarioByIdUseCase = retornarUsuarioByIdUseCase;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null) {
            var email = tokenService.validarToken((String) token);
            UserDetails usuario = retornarUsuarioByIdUseCase.retornaUsuarioByEmail(email);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private Object recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}
