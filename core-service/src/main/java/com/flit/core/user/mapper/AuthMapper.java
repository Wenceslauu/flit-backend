package com.flit.core.user.mapper;

import com.flit.core.user.dto.response.LoginResponseDto;
import com.flit.core.user.dto.view.TokensViewDto;
import org.mapstruct.Mapper;

@Mapper
public interface AuthMapper {
    LoginResponseDto tokensViewToLoginResponse(TokensViewDto tokensViewDto);
}
