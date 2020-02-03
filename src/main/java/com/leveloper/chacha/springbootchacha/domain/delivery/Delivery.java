package com.leveloper.chacha.springbootchacha.domain.delivery;

import com.leveloper.chacha.springbootchacha.domain.user.Address;
import com.leveloper.chacha.springbootchacha.domain.BaseTimeEntity;
import com.leveloper.chacha.springbootchacha.domain.order.Order;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
public class Delivery extends BaseTimeEntity {
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
