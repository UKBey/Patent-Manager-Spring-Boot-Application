package com.patentmanager.PatentManager.exception;

public class InvalidPatentDataException extends RuntimeException {
  public InvalidPatentDataException() {
    super(ErrorMessage.ERROR_INVALID_PATENT_DATA);
  }
}