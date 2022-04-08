package com.eddicorp.javabackendboilerplate.authentication.application;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class GetAccessTokenRequest {

    private final String state;
    private final String code;
}
