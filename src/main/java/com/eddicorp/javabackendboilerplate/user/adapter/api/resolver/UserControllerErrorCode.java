package com.eddicorp.javabackendboilerplate.user.adapter.api.resolver;

import lombok.Getter;

@Getter
public enum UserControllerErrorCode {

    UNHANDLED("USER_0000", "Unhandled Exception"),
    EMAIL_ALREADY_TAKEN("USER_1000", "Email already taken."),
    USER_NOT_FOUND("USER_1001", "User not found.")
    ;

    private final String code;
    private final String reasonPhrase;

    UserControllerErrorCode(String code, String reasonPhrase) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }
}
