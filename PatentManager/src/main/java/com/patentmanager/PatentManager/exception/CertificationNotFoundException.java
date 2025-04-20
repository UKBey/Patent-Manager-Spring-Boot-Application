package com.patentmanager.PatentManager.exception;

public class CertificationNotFoundException extends RuntimeException {
    public CertificationNotFoundException() {
        super(ErrorMessage.ERROR_CERTIFICATION_NOT_FOUND);
    }
}