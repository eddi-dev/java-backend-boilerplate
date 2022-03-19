package com.eddicorp.javabackendboilerplate.user.adapter.api;

import com.eddicorp.javabackendboilerplate.user.adapter.api.dto.UserSignUpRequest;
import com.eddicorp.javabackendboilerplate.user.adapter.api.dto.UserSignUpResponse;
import com.eddicorp.javabackendboilerplate.user.application.UserSignUpService;
import com.eddicorp.javabackendboilerplate.user.application.dto.UserSignUpCommand;
import com.eddicorp.javabackendboilerplate.user.application.dto.UserSignUpResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserSignUpService userSignUpService;

    @PostMapping
    public UserSignUpResponse signUp(@RequestBody UserSignUpRequest request) {
        final UserSignUpResult result = userSignUpService.executeSignUp(
                new UserSignUpCommand(request.getEmail(), request.getName())
        );
        return new UserSignUpResponse(
                result.getId()
        );
    }
}
