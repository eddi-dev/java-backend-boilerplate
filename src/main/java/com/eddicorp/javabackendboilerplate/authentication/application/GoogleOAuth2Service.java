package com.eddicorp.javabackendboilerplate.authentication.application;

import com.eddicorp.javabackendboilerplate.appSupports.Converter;
import com.eddicorp.javabackendboilerplate.authentication.application.dto.GoogleAccessTokenRequest;
import com.eddicorp.javabackendboilerplate.authentication.application.dto.GoogleUserProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Slf4j
@Component
public class GoogleOAuth2Service implements OAuth2Service {

    private final String authorizationUrl;
    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String accessTokenUrl;
    private final String userProfileUrl;
    private final RestTemplate restTemplate;

    public GoogleOAuth2Service(
            @Value("${app.oauth2.google.authorization-url}") String authorizationUrl,
            @Value("${app.oauth2.google.client-id}") String clientId,
            @Value("${app.oauth2.google.client-secret}") String clientSecret,
            @Value("${app.oauth2.google.redirect-uri}") String redirectUri,
            @Value("${app.oauth2.google.access-token-url}") String accessTokenUrl,
            @Value("${app.oauth2.google.user-profile-url}") String userProfileUrl,
            RestTemplate restTemplate
    ) {
        this.authorizationUrl = authorizationUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.accessTokenUrl = accessTokenUrl;
        this.restTemplate = restTemplate;
        this.userProfileUrl = userProfileUrl;
    }

    @Override
    public String getAuthorizationUrl() {
        final String authorizationUrl = UriComponentsBuilder.fromUriString(this.authorizationUrl)
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", redirectUri)
                .queryParam("response_type", "code")
                .queryParam("scope", URLEncoder.encode("profile email", StandardCharsets.UTF_8))
                .queryParam("state", UUID.randomUUID().toString())
                .queryParam("include_granted_scopes", true)
                .build().toUriString();
        log.debug("redirect to {}", authorizationUrl);
        return authorizationUrl;
    }

    @Override
    public AccessToken refreshAccessToken(GetAccessTokenRequest request) {
        final HttpEntity<GoogleAccessTokenRequest> entity = new HttpEntity<>(new GoogleAccessTokenRequest(
                clientId,
                clientSecret,
                request.getCode(),
                "authorization_code",
                redirectUri
        ));
        final AccessToken accessToken = restTemplate.postForObject(accessTokenUrl, entity, AccessToken.class);
        log.debug("access token from google: {}", accessToken);
        return accessToken;
    }

    @Override
    public UserProfile fetchUserProfile(AccessToken accessToken) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessToken.getAccessToken());
        final HttpEntity<Object> entity = new HttpEntity<>(null, httpHeaders);
        final GoogleUserProfile profileFromGoogle = restTemplate.exchange(
                userProfileUrl, HttpMethod.GET, entity, GoogleUserProfile.class
        ).getBody();
        log.debug("user profile from google: {}", profileFromGoogle);

        final UserProfile userProfile = new UserProfile(
                profileFromGoogle.getId(),
                profileFromGoogle.getEmail(),
                profileFromGoogle.getName(),
                Boolean.valueOf(profileFromGoogle.getVerifiedEmail()),
                profileFromGoogle.getPicture(),
                Converter.stringify(profileFromGoogle)
        );
        log.debug("user profile: {}", userProfile);
        return userProfile;
    }
}
