package com.leveloper.chacha.springbootchacha.service.user;

import com.leveloper.chacha.springbootchacha.controller.dto.UserSaveRequestDto;
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
}

