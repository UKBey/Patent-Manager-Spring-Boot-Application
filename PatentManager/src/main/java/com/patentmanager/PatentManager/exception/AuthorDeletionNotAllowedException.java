package com.patentmanager.PatentManager.exception;

public class AuthorDeletionNotAllowedException extends RuntimeException {
    public AuthorDeletionNotAllowedException() {
        super(ErrorMessage.ERROR_AUTHOR_DELETION_NOT_ALLOWED);
    }
}