package com.eddicorp.javabackendboilerplate.authentication.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserProfile {
    private final String idFromProvider;
    private final String email;
    private final String name;
    private final boolean isVerifiedEmail;
    private final String picture;
    private final String jsonFromProvider;
}
