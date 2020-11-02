package com.kirankasa.oauth2clientresourceserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello( @AuthenticationPrincipal  User oidcUser) {
        System.out.println("Oidc User : "+oidcUser);
        //System.out.println("JWT: "+jwt);
        return "Hello";
    }
}
