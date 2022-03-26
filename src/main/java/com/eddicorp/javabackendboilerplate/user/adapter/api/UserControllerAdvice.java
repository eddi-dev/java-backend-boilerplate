package com.eddicorp.javabackendboilerplate.user.adapter.api;

import com.eddicorp.javabackendboilerplate.user.adapter.api.resolver.UserControllerException;
import com.eddicorp.javabackendboilerplate.user.adapter.api.resolver.UserExceptionResolver;
import com.eddicorp.javabackendboilerplate.user.application.exception.UserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = {UserController.class})
public class UserControllerAdvice {

    @ExceptionHandler(UserException.class)
    public UserControllerException resolve(UserException userException) {
        return UserExceptionResolver.resolve(userException);
    }
}
