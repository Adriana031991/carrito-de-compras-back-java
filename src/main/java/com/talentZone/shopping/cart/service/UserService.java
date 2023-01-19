package com.talentZone.shopping.cart.service;

import com.talentZone.shopping.cart.dto.UserRequestDto;
import com.talentZone.shopping.cart.dto.UserResponseDto;

public interface UserService {
    UserResponseDto authenticate(UserRequestDto userRequestDto);
}
