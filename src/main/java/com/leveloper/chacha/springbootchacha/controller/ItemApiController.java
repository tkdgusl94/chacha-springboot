package com.leveloper.chacha.springbootchacha.controller;

import com.leveloper.chacha.springbootchacha.controller.dto.BookSaveRequestDto;
import com.leveloper.chacha.springbootchacha.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ItemApiController {
    private final ItemService itemService;

    @PostMapping("/api/v1/item")
    public Long createItem(@RequestParam("file") MultipartFile file,
                           @RequestParam("name") String name,
                           @RequestParam("price") int price,
                           @RequestParam("stockQuantity") int stockQuantity,
                           @RequestParam("author") String author,
                           @RequestParam("isbn") String isbn) throws IOException {

        BookSaveRequestDto requestDto = BookSaveRequestDto.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .author(author)
                .isbn(isbn)
                .build();

        return itemService.save(requestDto, file);
    }
}
