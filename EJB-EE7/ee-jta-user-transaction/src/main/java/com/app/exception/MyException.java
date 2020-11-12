package com.app.exception;


import javax.ejb.ApplicationException;

@ApplicationException(rollback = false, inherited = true)
public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
    }
}
