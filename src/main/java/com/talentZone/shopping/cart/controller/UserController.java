package com.talentZone.shopping.cart.controller;

import com.talentZone.shopping.cart.dto.UserRequestDto;
import com.talentZone.shopping.cart.dto.UserResponseDto;
import com.talentZone.shopping.cart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/authenticate")
    private ResponseEntity authenticate(@RequestBody UserRequestDto userRequestDto) {
        try {
            UserResponseDto userResponseDto = userService.authenticate(userRequestDto);
            return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
