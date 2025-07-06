package com.flit.core.user.controller;

import com.flit.core.user.dto.request.LoginRequestDto;
import com.flit.core.user.dto.request.SignUpRequestDto;
import com.flit.core.user.dto.response.LoginResponseDto;
import com.flit.core.user.mapper.AuthMapper;
import com.flit.core.user.service.AuthService;
import com.flit.core.user.service.KeycloakService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/public")
public class AuthController {

    private final AuthService authService;
    private final AuthMapper authMapper;

    public AuthController(AuthService authService, AuthMapper authMapper) {
        this.authService = authService;
        this.authMapper = authMapper;
    }

    @PostMapping(path = "/login")
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestBody) {
        var tokens = authService.login(requestBody.getEmail(), requestBody.getPassword());

        var responseBody = authMapper.tokensViewToLoginResponse(tokens);

        return ResponseEntity.ok(responseBody);
    }

    @PostMapping(path = "/signup")
    ResponseEntity<Void> signUp(@RequestBody SignUpRequestDto requestBody) {
        authService.signUp(requestBody.getEmail(), requestBody.getPassword(), requestBody.getRole());

        return ResponseEntity.ok().build();
    }
}
