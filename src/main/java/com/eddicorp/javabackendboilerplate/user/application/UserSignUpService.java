package com.eddicorp.javabackendboilerplate.user.application;

import com.eddicorp.javabackendboilerplate.user.application.dto.UserSignUpCommand;
import com.eddicorp.javabackendboilerplate.user.application.dto.UserSignUpResult;

public interface UserSignUpService {

    UserSignUpResult executeSignUp(UserSignUpCommand request);
}
