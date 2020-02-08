package com.leveloper.chacha.springbootchacha.domain.item;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="item_type")
@Getter
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long id;

    @Column(length = 100)
    private String name;

    @Column
    private int price;

    @Column
    private int stockQuantity;

    public void setItem(String name, int price, int stockQuantity){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
