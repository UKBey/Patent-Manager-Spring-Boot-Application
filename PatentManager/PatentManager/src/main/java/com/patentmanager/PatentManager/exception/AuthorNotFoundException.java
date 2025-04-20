package com.patentmanager.PatentManager.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException() {
        super(ErrorMessage.ERROR_AUTHOR_NOT_FOUND);
    }
}