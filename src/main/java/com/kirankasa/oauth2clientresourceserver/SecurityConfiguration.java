package com.kirankasa.oauth2clientresourceserver;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .oidcUserService(oidcUserService()).and()
                .and()
                .oauth2ResourceServer()
                .jwt();
    }

    private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
        return oidcUserRequest -> {
            OidcUserService oidcUserService = new OidcUserService();
            OidcUser oidcUser = oidcUserService.loadUser(oidcUserRequest);
            return oidcUser;
        };
    }
}
