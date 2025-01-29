package com.marcelospring.forumhub.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistingEmailException extends Exception {

    public ExistingEmailException(String message) {
        super(message);
    }
}
