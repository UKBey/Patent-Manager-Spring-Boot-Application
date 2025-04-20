package com.patentmanager.PatentManager.exception;

public class InvalidCertificationDataException extends RuntimeException {
    public InvalidCertificationDataException() {
        super(ErrorMessage.ERROR_INVALID_CERTIFICATION_DATA);
    }
}