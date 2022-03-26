package com.eddicorp.javabackendboilerplate.user.adapter.api;

import com.eddicorp.javabackendboilerplate.user.adapter.api.dto.UserSearchResponse;
import com.eddicorp.javabackendboilerplate.user.adapter.api.dto.UserSignUpRequest;
import com.eddicorp.javabackendboilerplate.user.adapter.api.dto.UserSignUpResponse;
import com.eddicorp.javabackendboilerplate.user.application.UserQueryService;
import com.eddicorp.javabackendboilerplate.user.application.UserSearchQuery;
import com.eddicorp.javabackendboilerplate.user.application.UserSearchQueryResult;
import com.eddicorp.javabackendboilerplate.user.application.UserSignUpService;
import com.eddicorp.javabackendboilerplate.user.application.UserSignUpCommand;
import com.eddicorp.javabackendboilerplate.user.application.UserSignUpResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserQueryService userQueryService;

    @PostMapping
    public UserSignUpResponse signUp(@RequestBody UserSignUpRequest request) {
        final UserSignUpResult result = userSignUpService.executeSignUp(
                new UserSignUpCommand(request.getEmail(), request.getName())
        );
        return new UserSignUpResponse(
                result.getId()
        );
    }

    @GetMapping("/{id}")
    public UserSearchResponse search(@PathVariable String id) {
        final UserSearchQueryResult result = userQueryService.query(new UserSearchQuery(id));
        return new UserSearchResponse(
                result.getEmail(),
                result.getDisplayName()
        );
    }
}
