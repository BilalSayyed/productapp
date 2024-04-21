package com.bca.controller;

import com.bca.dto.ErrorInfo;
import com.bca.util.ProductNotFoundException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    public ExceptionHandlerController() {
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<ErrorInfo> handle404(ProductNotFoundException exception) {
        ErrorInfo errorInfo = ErrorInfo.builder().errorMessage(exception.getMessage()).status(HttpStatus.NOT_FOUND.toString()).timestamp(LocalDateTime.now()).toContact("email@email.com").build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorInfo> handleAllException(Exception exception) {
        ErrorInfo errorInfo = ErrorInfo.builder().errorMessage(exception.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.toString()).timestamp(LocalDateTime.now()).toContact("email@email.com").build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorInfo> validationException(MethodArgumentNotValidException exception) {
        String message = (String)exception.getBindingResult().getAllErrors().stream().map((x) -> {
            return x.getDefaultMessage();
        }).collect(Collectors.joining(","));
        ErrorInfo errorInfo = ErrorInfo.builder().errorMessage(message).status(HttpStatus.INTERNAL_SERVER_ERROR.toString()).timestamp(LocalDateTime.now()).toContact("email@email.com").build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
    }
}