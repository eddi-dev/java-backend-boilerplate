package com.eddicorp.javabackendboilerplate.authentication.adapter.api;

import com.eddicorp.javabackendboilerplate.authentication.application.AccessToken;
import com.eddicorp.javabackendboilerplate.authentication.application.GetAccessTokenRequest;
import com.eddicorp.javabackendboilerplate.authentication.application.GoogleOAuth2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/authentication/oauth2")
public class OAuth2AuthenticationController {

    // provider가 더 생기면 그 땐 factory로 분리 필요
    private final GoogleOAuth2Service googleOAuth2Service;

    @GetMapping("/google")
    public void sendRedirectToGoogleAuthorizationUrl(
            HttpServletResponse response
    ) {
        final String googleAuthorizationUrl = googleOAuth2Service.getAuthorizationUrl();
        try {
            response.sendRedirect(googleAuthorizationUrl);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    @GetMapping("/google/redirect")
    public void processCallbackAndSendRedirectToSigningFormUrl(
            @RequestParam("state") String state,
            @RequestParam("code") String code,
            @RequestParam("scope") String scope,
            @RequestParam("authuser") String authUser,
            @RequestParam("prompt") String prompt,
            HttpServletResponse response
    ) {
        final AccessToken accessToken = googleOAuth2Service.refreshAccessToken(
                new GetAccessTokenRequest(
                        state,
                        code
                )
        );
        googleOAuth2Service.fetchUserProfile(accessToken);
        final Cookie cookie = new Cookie("key", "value");
        cookie.setDomain("api-local.moim.place:8080");
        response.addCookie(cookie);
        try {
            response.sendRedirect("local.moim.place:3000");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
