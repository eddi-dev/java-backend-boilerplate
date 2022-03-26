package com.eddicorp.javabackendboilerplate.user.application.exception;

public class UserAlreadyExistException extends UserException {

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
