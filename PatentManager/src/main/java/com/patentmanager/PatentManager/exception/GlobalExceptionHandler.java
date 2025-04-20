package com.patentmanager.PatentManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;


import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 🔹 Validation hatalarını yakala (DTO @Valid için)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // 🔹 Not Found Exception’lar
    @ExceptionHandler({
            AuthorNotFoundException.class,
            PatentNotFoundException.class,
            CertificationNotFoundException.class
    })
    public ResponseEntity<ErrorResponse> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    // 🔹 Invalid Data Exception’lar (isteğe bağlı)
    @ExceptionHandler({
            InvalidAuthorDataException.class,
            InvalidPatentDataException.class,
            InvalidCertificationDataException.class
    })
    public ResponseEntity<ErrorResponse> handleInvalidData(RuntimeException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidJson(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ErrorMessage.ERROR_INVALID_CERTIFICATION_DATA),
                HttpStatus.BAD_REQUEST
        );
    }
    // 🔹 Silinmeye izin verilmeyen durumlar
    @ExceptionHandler({
            AuthorDeletionNotAllowedException.class,
            PatentDeletionNotAllowedException.class
    })
    public ResponseEntity<ErrorResponse> handleDeletionNotAllowed(RuntimeException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.CONFLICT);
    }

    // 🔹 Tüm diğer bilinmeyen hatalar
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse("Beklenmeyen bir hata oluştu: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}