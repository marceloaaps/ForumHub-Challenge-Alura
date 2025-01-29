package com.marcelospring.forumhub.infra.exceptions;

import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingMessageException;
import com.marcelospring.forumhub.core.use_cases.exceptions.ExistingTitleException;
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

}
