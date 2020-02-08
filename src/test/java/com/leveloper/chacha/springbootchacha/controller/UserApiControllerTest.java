package com.leveloper.chacha.springbootchacha.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leveloper.chacha.springbootchacha.controller.dto.UserSaveRequestDto;
import com.leveloper.chacha.springbootchacha.domain.item.Item;
import com.leveloper.chacha.springbootchacha.domain.user.User;
import com.leveloper.chacha.springbootchacha.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void user정보가_저장된다() throws Exception{
        //given
        String name = "name";
        String email = "email";
        String picture = "picture";

        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .build();

        String url = "http://localhost:" + port + "/api/v1/user";
        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<User> list = userRepository.findAll();
        assertEquals(list.get(0).getName(), name);
        assertEquals(list.get(0).getEmail(), email);
        assertEquals(list.get(0).getPicture(), picture);
    }

}