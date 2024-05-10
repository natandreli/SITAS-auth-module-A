package com.sitas.authmodule.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(){
        super();
    }

    public InvalidCredentialsException(String message){
        super(message);
    }
}
