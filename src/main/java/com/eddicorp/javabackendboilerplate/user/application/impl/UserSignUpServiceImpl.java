package com.eddicorp.javabackendboilerplate.user.application.impl;

import com.eddicorp.javabackendboilerplate.user.application.UserSignUpService;
import com.eddicorp.javabackendboilerplate.user.application.dto.UserSignUpCommand;
import com.eddicorp.javabackendboilerplate.user.application.dto.UserSignUpResult;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUser;
import com.eddicorp.javabackendboilerplate.user.domain.BoilerplateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignUpServiceImpl implements UserSignUpService {

    private final BoilerplateUserRepository repository;

    @Override
    public UserSignUpResult executeSignUp(UserSignUpCommand request) {
        final BoilerplateUser newUser = BoilerplateUser.createNewBoilerplateUser(
                request.getEmail(),
                request.getName()
        );
        final BoilerplateUser savedUser = repository.save(newUser);
        return new UserSignUpResult(savedUser.getId().getValue());
    }
}
