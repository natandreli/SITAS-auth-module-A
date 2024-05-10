package com.sitas.authmodule.exception;

public class PersonAlreadyExistsException extends RuntimeException {
    public PersonAlreadyExistsException()
    {
        super();
    }

    public PersonAlreadyExistsException(String message) {
        super(message);
    }
}
