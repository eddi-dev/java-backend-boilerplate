package com.eddicorp.javabackendboilerplate.authentication.domain;

public class BoilerplateOAuth2Authentication extends BoilerplateAuthenticationBase {

    private final String email;
    private final String oauth2Code;
    private final OAuth2Provider provider;

    private BoilerplateOAuth2Authentication(BoilerplateAuthenticationId authenticationId,
                                           BoilerplateAuthUserId authUserId,
                                           String email,
                                           String oauth2Code,
                                           OAuth2Provider provider) {
        super(authenticationId, authUserId);
        this.email = email;
        this.oauth2Code = oauth2Code;
        this.provider = provider;
    }

    public static BoilerplateOAuth2Authentication newGoogleAuthentication(
            String email,
            String oauth2Code,
            OAuth2Provider provider,
            String userId
    ) {
        final BoilerplateAuthenticationId newAuthId = BoilerplateAuthenticationId.createNewId();
        final BoilerplateAuthUserId authUserId = BoilerplateAuthUserId.from(userId);
        return new BoilerplateOAuth2Authentication(
                newAuthId,
                authUserId,
                email,
                oauth2Code,
                provider
        );
    }
}
