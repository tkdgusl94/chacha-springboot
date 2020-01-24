package com.leveloper.chacha.springbootchacha.controller;

import com.leveloper.chacha.springbootchacha.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApiControllerTests {
    @Autowired
    UserService userService;

    @Test
    public void user_정보_저장된다(){

    }
}
