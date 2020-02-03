package com.leveloper.chacha.springbootchacha.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;

@Getter
@AllArgsConstructor
public class Address {
    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String street;

    @Column(length = 20)
    private String zipcode;

    public void update(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
