package com.flit.core.user.dto.request;

import com.flit.core.user.enums.Role;

public record SignUpRequestDto(String email, String password, Role role) { }
