package com.flit.core.user.service;

import com.flit.core.user.dto.view.TokensViewDto;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.stereotype.Service;

@Service
public class KeycloakService {

    private final KeycloakBuilder keycloakClientBuilder;

    public KeycloakService(KeycloakBuilder keycloakClientBuilder) {
        this.keycloakClientBuilder = keycloakClientBuilder;
    }

    public TokensViewDto getTokens(String email, String password) {
        Keycloak keycloakClient = keycloakClientBuilder
                .username(email)
                .password(password)
                .build();

        AccessTokenResponse tokenResponse = keycloakClient.tokenManager().getAccessToken();

        return new TokensViewDto(
                tokenResponse.getToken(),
                tokenResponse.getRefreshToken()
        );
    }
}
