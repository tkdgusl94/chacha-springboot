package com.leveloper.chacha.springbootchacha.domain.item;

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
}
