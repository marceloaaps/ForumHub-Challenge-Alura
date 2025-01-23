package com.marcelospring.forumhub.infra.exceptions;

public class ExistingEmailException extends Exception {

    public ExistingEmailException(String message) {
        super("Email já cadastrado" + message);
    }
}
