package com.leveloper.chacha.springbootchacha.controller;

import com.leveloper.chacha.springbootchacha.controller.dto.UserSaveRequestDto;
import com.leveloper.chacha.springbootchacha.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public String save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }
}

