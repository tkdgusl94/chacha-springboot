package com.leveloper.chacha.springbootchacha.service;

import com.leveloper.chacha.springbootchacha.aws.S3Uploader;
import com.leveloper.chacha.springbootchacha.controller.dto.BookSaveRequestDto;
import com.leveloper.chacha.springbootchacha.controller.dto.BookResponseDto;
import com.leveloper.chacha.springbootchacha.domain.item.Book;
import com.leveloper.chacha.springbootchacha.domain.item.Item;
import com.leveloper.chacha.springbootchacha.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;
    private final S3Uploader s3Uploader;

    @Transactional
    public Long save(BookSaveRequestDto requestDto, MultipartFile file) throws IOException {
        String imgUrl = s3Uploader.upload(file, "static");
        Book book = requestDto.toEntity();
        book.setImgUrl(imgUrl);
        return itemRepository.save(book).getId();
    }

    public BookResponseDto findById(Long id) {
        Book book = (Book) itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id = " + id));
        return new BookResponseDto(book);
    }
}