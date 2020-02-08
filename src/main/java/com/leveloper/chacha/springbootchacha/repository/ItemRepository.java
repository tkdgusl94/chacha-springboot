package com.leveloper.chacha.springbootchacha.repository;

import com.leveloper.chacha.springbootchacha.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
