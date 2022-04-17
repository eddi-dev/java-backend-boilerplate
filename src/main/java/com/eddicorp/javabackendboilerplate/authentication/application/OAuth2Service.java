package com.eddicorp.javabackendboilerplate.authentication.application;

public interface OAuth2Service {

    /**
     * @return authorization url
     */
    String getAuthorizationUrl();

    /**
     * @param
     * @return access token
     */
    AccessToken refreshAccessToken(GetAccessTokenRequest request);

    UserProfile fetchUserProfile(AccessToken accessToken);
}
