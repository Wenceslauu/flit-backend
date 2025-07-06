package com.flit.core.user.dto.request;

import com.flit.core.user.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignUpRequestDto {
    private final String email;
    private final String password;
    private final Role role;
}
