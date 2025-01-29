package com.marcelospring.forumhub.infra.exceptions;

import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingEmailException;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingMessageException;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingTitleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExistingEmailException.class)
    public ResponseEntity<Map<String, String>> handleExistingEmailException(ExistingEmailException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Email já cadastrado");
        response.put("details", ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ExistingMessageException.class)
    public ResponseEntity<Map<String, String>> handleExistingMessageException(ExistingMessageException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Mensagem já cadastrada");
        response.put("details", ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ExistingTitleException.class)
    public ResponseEntity<Map<String, String>> handleExistingTitleException(ExistingTitleException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Titulo já cadastrado");
        response.put("details", ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NonAuthorizedEmailExceotion.class)
    public ResponseEntity<Map<String, String>> handleNullEmailException(NonAuthorizedEmailExceotion ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Credencial de email equivocada");
        response.put("Email: ", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Erro, recurso não encontrado: ", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCredentialException(InvalidCredentialException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Credencial inválida: ");
        response.put("details", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(CantProcessException.class)
    public ResponseEntity<Map<String, String>> handleCantProcessException(CantProcessException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Erro ao processar credencial");
        response.put("details: ", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
