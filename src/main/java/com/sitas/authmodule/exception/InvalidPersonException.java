package com.sitas.authmodule.exception;

public class InvalidPersonException extends RuntimeException{
    public InvalidPersonException()
    {
        super();
    }

    public InvalidPersonException(String message) {
        super(message);
    }
}
