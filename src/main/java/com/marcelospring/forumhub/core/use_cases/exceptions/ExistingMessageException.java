package com.marcelospring.forumhub.core.use_cases.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistingMessageException extends RuntimeException {

    public ExistingMessageException(String message) {
        super(message);
    }
}
