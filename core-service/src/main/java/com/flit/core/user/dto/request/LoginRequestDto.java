package com.flit.core.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginRequestDto {
    private final String email;
    private final String password;
}
