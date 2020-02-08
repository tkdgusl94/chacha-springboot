package com.leveloper.chacha.springbootchacha.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("BOOK")
public class Book extends Item{
    @Column(length = 50)
    private String author;

    @Column(length = 50)
    private String isbn;

    @Builder
    public Book(String name, int price, int stockQuantity, String author, String isbn){
        super.setItem(name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }

}
