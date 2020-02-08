package com.leveloper.chacha.springbootchacha.controller;

import com.leveloper.chacha.springbootchacha.controller.dto.BookSaveRequestDto;
import com.leveloper.chacha.springbootchacha.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ItemApiController {
    private final ItemService itemService;

    @PostMapping("/api/v1/item")
    public Long createItem(@RequestBody BookSaveRequestDto requestDto){
        return itemService.save(requestDto);
    }
}
