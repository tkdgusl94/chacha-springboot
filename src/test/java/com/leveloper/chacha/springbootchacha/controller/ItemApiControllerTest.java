package com.leveloper.chacha.springbootchacha.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leveloper.chacha.springbootchacha.controller.dto.BookSaveRequestDto;
import com.leveloper.chacha.springbootchacha.domain.item.Book;
import com.leveloper.chacha.springbootchacha.domain.item.Item;
import com.leveloper.chacha.springbootchacha.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
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
public class ItemApiControllerTest {

    @LocalServerPort
    private int port;

//    @Autowired
//    private TestRestTemplate restTemplate;

    @Autowired
    private ItemRepository itemRepository;

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
    public void item이_등록된다() throws Exception {
        //given
        String name = "name";
        int price = 1000;
        int stockQuantity = 100;
        String author = "author";
        String isbn = "isbn";

        BookSaveRequestDto requestDto = BookSaveRequestDto.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .author(author)
                .isbn(isbn)
                .build();

        String url = "http://localhost:" + port + "/api/v1/item";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Item> list = itemRepository.findAll();
        assertEquals(list.get(0).getName(), name);
        assertEquals(list.get(0).getPrice(), price);
    }
}