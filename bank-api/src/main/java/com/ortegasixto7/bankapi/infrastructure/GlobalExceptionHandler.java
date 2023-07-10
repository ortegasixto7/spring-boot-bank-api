package com.ortegasixto7.bankapi.infrastructure;

import com.ortegasixto7.bankapi.infrastructure.exceptions.BadRequestException;
import com.ortegasixto7.bankapi.infrastructure.exceptions.CustomResponseError;
import com.ortegasixto7.bankapi.infrastructure.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponseError());
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<CustomResponseError> handleBadRequestException(BadRequestException ex) {
        var response = new CustomResponseError();
        response.error = ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomResponseError> handleNotFoundException(NotFoundException ex) {
        var response = new CustomResponseError();
        response.error = ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CustomResponseError> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CustomResponseError());
    }

}

