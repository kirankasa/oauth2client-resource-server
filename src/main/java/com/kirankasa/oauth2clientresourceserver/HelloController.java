package com.kirankasa.oauth2clientresourceserver;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal OidcUser oidcUser, @AuthenticationPrincipal Jwt jwt) {
        System.out.println("Oidc User : "+oidcUser);
        System.out.println("JWT: "+jwt);
        return "Hello";
    }
}
