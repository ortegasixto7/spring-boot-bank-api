package com.ortegasixto7.bankapi.infrastructure.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(ExceptionCode message){
        super(message.toString());
    }

}
