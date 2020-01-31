package com.leveloper.chacha.springbootchacha.service.user;

import com.leveloper.chacha.springbootchacha.controller.dto.UserSaveRequestDto;
import com.leveloper.chacha.springbootchacha.domain.user.User;
import com.leveloper.chacha.springbootchacha.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String save(UserSaveRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getEmail();
    }

    public User findByName(String name) {
        //User user = userRepository.test(name).orElseThrow(()->new IllegalArgumentException("no name"));
        User user = userRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("no name"));
        return user;
    }
}

