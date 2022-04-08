package com.eddicorp.javabackendboilerplate.authentication.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoogleAccessTokenRequest {
    private String clientId;
    private String clientSecret;
    private String code;
    private String grantType;
    private String redirectUri;
}
