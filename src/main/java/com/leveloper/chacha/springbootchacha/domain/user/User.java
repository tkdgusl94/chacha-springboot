package com.leveloper.chacha.springbootchacha.domain.user;

import com.leveloper.chacha.springbootchacha.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String picture;

    @Builder
    public User(String password, String name, String email, String picture, Role role) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }
}


