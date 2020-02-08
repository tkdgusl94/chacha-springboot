package com.leveloper.chacha.springbootchacha.controller.dto;

import com.leveloper.chacha.springbootchacha.domain.item.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookSaveRequestDto {
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

    @Builder
    public BookSaveRequestDto(String name, int price, int stockQuantity, String author, String isbn){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.author = author;
        this.isbn = isbn;
    }

    public Book toEntity(){
        return Book.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .author(author)
                .isbn(isbn)
                .build();
    }
}
