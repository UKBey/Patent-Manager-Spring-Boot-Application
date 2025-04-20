package com.patentmanager.PatentManager.exception;

public class InvalidAuthorDataException extends RuntimeException {
    public InvalidAuthorDataException() {
        super(ErrorMessage.ERROR_INVALID_AUTHOR_DATA);
    }
}