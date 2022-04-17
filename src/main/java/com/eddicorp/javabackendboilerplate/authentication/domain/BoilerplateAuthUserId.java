package com.eddicorp.javabackendboilerplate.authentication.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BoilerplateAuthUserId {

    private final String authUserId;

    public static BoilerplateAuthUserId from(String value) {
        return new BoilerplateAuthUserId(value);
    }
}
