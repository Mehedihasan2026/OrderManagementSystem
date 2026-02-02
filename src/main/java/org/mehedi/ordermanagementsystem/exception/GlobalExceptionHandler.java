package org.mehedi.ordermanagementsystem.exception;

import org.mehedi.ordermanagementsystem.model.GenericResponse;
import org.mehedi.ordermanagementsystem.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<GenericResponse>  orderNotFoundException(OrderNotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(ResponseUtil.setErrorResponse(404, e));
    }
}
