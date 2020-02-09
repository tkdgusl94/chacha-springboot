package com.leveloper.chacha.springbootchacha.controller.dto;

import com.leveloper.chacha.springbootchacha.domain.item.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemResponseDto {
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;
}
