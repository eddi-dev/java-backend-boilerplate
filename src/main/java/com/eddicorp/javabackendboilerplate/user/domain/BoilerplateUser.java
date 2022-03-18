package com.eddicorp.javabackendboilerplate.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BoilerplateUser {

    private final BoilerplateUserId id;
    private final String email;
    private final String displayName;

    public static BoilerplateUser createNewBoilerplateUser(String email, String displayName) {
        return new BoilerplateUser(BoilerplateUserId.createNewId(), email, displayName);
    }

    public static BoilerplateUser from(String id, String email, String displayName) {
        return new BoilerplateUser(
                BoilerplateUserId.from(id),
                email,
                displayName
        );
    }
}
