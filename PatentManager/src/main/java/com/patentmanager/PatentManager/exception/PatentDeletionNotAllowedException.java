package com.patentmanager.PatentManager.exception;

public class PatentDeletionNotAllowedException extends RuntimeException {
    public PatentDeletionNotAllowedException() {
        super(ErrorMessage.ERROR_PATENT_DELETION_NOT_ALLOWED);
    }
}