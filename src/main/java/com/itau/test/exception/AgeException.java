package com.itau.test.exception;

public class AgeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AgeException(String msg) {
        super(msg);
    }

}
