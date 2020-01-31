package com.leveloper.chacha.springbootchacha.controller;

import com.leveloper.chacha.springbootchacha.controller.dto.UserSaveRequestDto;
import com.leveloper.chacha.springbootchacha.domain.user.User;
import com.leveloper.chacha.springbootchacha.service.user.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public String save(@RequestBody UserSaveRequestDto requestDto){
        return userService.save(requestDto);
    }

    @GetMapping("/yes/{name}")
    public User test(@PathVariable("name") String name){
        return userService.findByName(name);
    }
}

