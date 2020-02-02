package com.leveloper.chacha.springbootchacha.controller.dto;

import com.leveloper.chacha.springbootchacha.domain.user.Role;
import com.leveloper.chacha.springbootchacha.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String password;
    private String name;
    private String email;
    private String picture;

    @Builder
    public UserSaveRequestDto(String password, String name, String email, String picture) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public User toEntity() {
        return User.builder()
                .password(password)
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.USER)
                .build();
    }
}

