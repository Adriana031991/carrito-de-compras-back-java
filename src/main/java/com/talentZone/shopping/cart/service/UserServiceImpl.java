package com.talentZone.shopping.cart.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.talentZone.shopping.cart.dto.UserRequestDto;
import com.talentZone.shopping.cart.dto.UserResponseDto;
import com.talentZone.shopping.cart.entity.User;
import com.talentZone.shopping.cart.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto authenticate(UserRequestDto userRequestDto) {
        UserResponseDto userResponse = new UserResponseDto();
        try {
            log.info("Inside authenticate {}", new ObjectMapper().writeValueAsString(userRequestDto));
            User user = userRepository.findUserByUsername(userRequestDto.getUsername());
            if (user != null && user.getUsername().equals(userRequestDto.getUsername())) {
                userResponse.setToken(UUID.randomUUID().toString());
            }
        } catch (JsonProcessingException e) {
            log.error("Error in authenticate method {}", e.getMessage(), e);
        }
        return userResponse;
    }
}
