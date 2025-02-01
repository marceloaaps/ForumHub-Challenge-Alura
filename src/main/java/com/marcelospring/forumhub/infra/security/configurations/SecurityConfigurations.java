package com.marcelospring.forumhub.infra.security.configurations;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    private static final String ADMIN = "ADMIN";
    private static final String MEMBER = "MEMBER";
    private static final String GUEST = "GUEST";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize

                        //Doc e gerais.
                        .requestMatchers("/swagger-ui/**", "/swagger-resources/**", "/v3/api-docs/**", "api-docs/**", "/actuator/**").permitAll()

                        // Autenticação e Login
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/registrar").permitAll()

                        // Resposta
                        .requestMatchers(HttpMethod.DELETE, "/respostas/deletar/{id}").hasAnyRole(ADMIN, MEMBER)
                        .requestMatchers(HttpMethod.PUT, "/respostas/atualizar/{id}").hasAnyRole(ADMIN, MEMBER)
                        .requestMatchers(HttpMethod.GET, "/respostas/procura-respostas/{id}").hasAnyRole(ADMIN, MEMBER)
                        .requestMatchers(HttpMethod.POST, "/respostas/adicionar-resposta").hasAnyRole(ADMIN, MEMBER)

                        // Usuario
                        .requestMatchers(HttpMethod.GET, "/usuarios/busca-nomes/{nome}").hasAnyRole(ADMIN, MEMBER)
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/deletar/{id}").hasRole(ADMIN)

                        // Topico
                        .requestMatchers(HttpMethod.PUT, "/topicos/atualizar/{id}").hasAnyRole(ADMIN, MEMBER)
                        .requestMatchers(HttpMethod.POST, "/topicos/criar-topico").hasAnyRole(ADMIN, MEMBER)
                        .requestMatchers(HttpMethod.GET, "/topicos/buscar-topico/{id}").hasAnyRole(ADMIN, MEMBER)
                        .requestMatchers(HttpMethod.DELETE, "/topicos/deletar/{id}").hasRole(ADMIN)

                        .anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(customAuthenticationEntryPoint()))
                .build();
    }

    @Bean
    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return (request, response, authException) -> {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\": \"Erro ao validar request!\"}");
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }
}