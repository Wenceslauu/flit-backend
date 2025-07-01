package com.flit.core.user.dto.view;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TokensViewDto {
    private final String accessToken;
    private final String refreshToken;
}
