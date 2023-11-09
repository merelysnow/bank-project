package com.github.merelysnow.bankproject.exception.controller;

import com.github.merelysnow.bankproject.exception.data.Exception;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity duplicateCredentials(DataIntegrityViolationException dataIntegrityViolationException) {
        final Exception exception = new Exception("Já possui um usuario cadastrado com essas credenciais", 400);

        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(java.lang.Exception.class)
    public ResponseEntity allExceptions(java.lang.Exception langException) {
        final Exception exception = new Exception(langException.getMessage(), 500);

        return ResponseEntity.internalServerError().body(exception);
    }
}
