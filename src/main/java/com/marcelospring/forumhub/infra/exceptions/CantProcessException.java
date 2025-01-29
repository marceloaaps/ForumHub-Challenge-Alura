package com.marcelospring.forumhub.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CantProcessException extends RuntimeException {
    public CantProcessException(String message) {
        super(message);
    }
}
