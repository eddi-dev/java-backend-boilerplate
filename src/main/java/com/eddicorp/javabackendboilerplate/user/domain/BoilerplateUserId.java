package com.eddicorp.javabackendboilerplate.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BoilerplateUserId {

    private final String value;

    public static BoilerplateUserId createNewId() {
        return new BoilerplateUserId(UUID.randomUUID().toString());
    }

    public static BoilerplateUserId from(String value) {
        return new BoilerplateUserId(value);
    }
}
