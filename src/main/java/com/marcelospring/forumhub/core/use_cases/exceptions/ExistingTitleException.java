package com.marcelospring.forumhub.core.use_cases.exceptions;

public class ExistingTitleException extends RuntimeException {

    public ExistingTitleException(String titulo) {
        super("Já existe um tópico com o título: " + titulo);
    }

}
