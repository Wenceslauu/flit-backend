package com.flit.core.user.controller;

import com.flit.core.user.dto.request.LoginRequestDto;
import com.flit.core.user.dto.response.LoginResponseDto;
import com.flit.core.user.dto.view.TokensViewDto;
import com.flit.core.user.mapper.AuthMapper;
import com.flit.core.user.service.KeycloakService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final KeycloakService keycloakService;
    private final AuthMapper authMapper;

    public AuthController(KeycloakService keycloakService, AuthMapper authMapper) {
        this.keycloakService = keycloakService;
        this.authMapper = authMapper;
    }

    @PostMapping(path = "/login")
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestBody) {
        var tokens = keycloakService.getTokens(requestBody.getEmail(), requestBody.getPassword());

        var responseBody = authMapper.tokensViewToLoginResponse(tokens);

        return ResponseEntity.ok(responseBody);
    }
}
