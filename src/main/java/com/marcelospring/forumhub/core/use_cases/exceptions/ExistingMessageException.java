package com.marcelospring.forumhub.core.use_cases.exceptions;

public class ExistingMessageException extends RuntimeException {

    public ExistingMessageException(String message) {
        super("Já existe essa mensagem cadastrada"+ message);
    }
}
