package com.leveloper.chacha.springbootchacha.controller.dto;

import com.leveloper.chacha.springbootchacha.domain.item.Book;
import lombok.Getter;

@Getter
public class BookResponseDto {
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;
    private String imgUrl;

    public BookResponseDto(Book book) {
        this.name = book.getName();
        this.price = book.getPrice();
        this.stockQuantity = book.getStockQuantity();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.imgUrl = book.getImgUrl();
    }
}
