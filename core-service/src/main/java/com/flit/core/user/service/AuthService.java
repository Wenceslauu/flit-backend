package com.flit.core.user.service;

import com.flit.core.user.dto.view.TokensViewDto;
import com.flit.core.user.enums.Role;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final KeycloakService keycloakService;

    public AuthService(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }

    public TokensViewDto login(String email, String password) {
        return keycloakService.getTokens(email, password);
    }

    public void signUp(String email, String password, Role role) {
        String userId = keycloakService.createUserInKc(email, password, role);
    }
}
