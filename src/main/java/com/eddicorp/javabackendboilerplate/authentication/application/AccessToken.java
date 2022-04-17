package com.eddicorp.javabackendboilerplate.authentication.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * FIXME: Google에 fit하게 짜놔서 수정 필요
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken {

    private String accessToken;
    private long expiresIn;
    private String scope;
    private String tokenType;
    private String idToken;
}
