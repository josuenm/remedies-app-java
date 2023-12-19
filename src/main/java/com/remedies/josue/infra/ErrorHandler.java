package com.remedies.josue.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> notFoundHandler() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationHandler(MethodArgumentNotValidException ex) {
        List<ValidationDTO> errors = ex.getFieldErrors().stream().map(ValidationDTO::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    public record ValidationDTO(String message, String field) {
        public ValidationDTO(FieldError error) {
            this(error.getDefaultMessage(), error.getField());
        }
    }
}
