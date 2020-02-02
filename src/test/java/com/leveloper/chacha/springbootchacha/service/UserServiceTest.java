package com.leveloper.chacha.springbootchacha.service;

import com.leveloper.chacha.springbootchacha.controller.dto.UserSaveRequestDto;
import com.leveloper.chacha.springbootchacha.domain.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @Transactional
    public void user_정보_저장된다() throws Exception{
        //given
        String name = "name";
        String email = "email";
        String picture = "picture";

        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .build();

        //when
        userService.save(requestDto);
        User user = userService.findByName(name);

        //then
        assertEquals(email, user.getEmail());
    }
}