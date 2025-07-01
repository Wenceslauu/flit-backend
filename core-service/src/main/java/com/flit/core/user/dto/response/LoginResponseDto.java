package com.flit.core.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponseDto {
    private final String accessToken;
    private final String refreshToken;
}
