package com.eddicorp.javabackendboilerplate.authentication.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BoilerplateAuthenticationBase {

    /**
     * 인증 식별자용 아이디
     */
    private final BoilerplateAuthenticationId authenticationId;

    /**
     * 인증받을 사용자 아이디
     */
    private final BoilerplateAuthUserId authUserId;
}
