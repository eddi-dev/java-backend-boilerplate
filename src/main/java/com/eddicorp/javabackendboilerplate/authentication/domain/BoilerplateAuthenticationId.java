package com.eddicorp.javabackendboilerplate.authentication.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BoilerplateAuthenticationId {

    private final String value;

    public static BoilerplateAuthenticationId createNewId() {
        return new BoilerplateAuthenticationId(UUID.randomUUID().toString());
    }

    public static BoilerplateAuthenticationId from(String value) {
        return new BoilerplateAuthenticationId(value);
    }
}
