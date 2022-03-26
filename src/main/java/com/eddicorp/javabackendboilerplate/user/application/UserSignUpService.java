package com.eddicorp.javabackendboilerplate.user.application;

public interface UserSignUpService {

    UserSignUpResult executeSignUp(UserSignUpCommand request);
}
