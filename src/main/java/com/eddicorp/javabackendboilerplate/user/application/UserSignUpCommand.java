package com.eddicorp.javabackendboilerplate.user.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSignUpCommand {
    private final String email;
    private final String name;
}
