package com.eddicorp.javabackendboilerplate.user.adapter.api.resolver;

import com.eddicorp.javabackendboilerplate.user.application.exception.UserAlreadyExistException;
import com.eddicorp.javabackendboilerplate.user.application.exception.UserException;
import com.eddicorp.javabackendboilerplate.user.application.exception.UserNotFoundException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserExceptionResolver {

    public UserControllerException resolve(UserException userException) {
        if (userException instanceof UserAlreadyExistException) {
            return new UserControllerException(UserControllerErrorCode.EMAIL_ALREADY_TAKEN);
        }

        if (userException instanceof UserNotFoundException) {
            return new UserControllerException(UserControllerErrorCode.USER_NOT_FOUND);
        }

        return new UserControllerException(UserControllerErrorCode.UNHANDLED);
    }
}
