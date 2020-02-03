package com.leveloper.chacha.springbootchacha.domain;

import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
public class Delivery extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private DeliveryStatus status;
}
