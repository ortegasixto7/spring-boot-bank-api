package com.ortegasixto7.bankapi.infrastructure.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Exception message){
        super(message.toString());
    }

}
