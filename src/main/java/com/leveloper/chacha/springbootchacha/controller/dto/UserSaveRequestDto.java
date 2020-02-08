package com.leveloper.chacha.springbootchacha.controller.dto;

import com.leveloper.chacha.springbootchacha.domain.user.Role;
import com.leveloper.chacha.springbootchacha.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String name;
    private String email;
    private String picture;

    @Builder
    public UserSaveRequestDto(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.USER)
                .build();
    }
}

