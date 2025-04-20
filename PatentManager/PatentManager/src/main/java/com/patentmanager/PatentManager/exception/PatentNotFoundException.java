package com.patentmanager.PatentManager.exception;

public class PatentNotFoundException extends RuntimeException {
    public PatentNotFoundException() {
        super(ErrorMessage.ERROR_PATENT_NOT_FOUND);
    }
}