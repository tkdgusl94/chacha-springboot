package com.leveloper.chacha.springbootchacha.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Entity
@DiscriminatorValue("MOVIE")
public class Movie extends Item{
    @Column(length = 30)
    private String director;

    private String actor;
}
