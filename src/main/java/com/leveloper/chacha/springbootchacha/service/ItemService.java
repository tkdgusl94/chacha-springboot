package com.leveloper.chacha.springbootchacha.service;

import com.leveloper.chacha.springbootchacha.controller.dto.BookSaveRequestDto;
import com.leveloper.chacha.springbootchacha.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long save(BookSaveRequestDto requestDto) {
        return itemRepository.save(requestDto.toEntity()).getId();
    }
}