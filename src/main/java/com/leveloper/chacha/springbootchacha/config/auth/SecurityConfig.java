package com.leveloper.chacha.springbootchacha.config.auth;

import com.leveloper.chacha.springbootchacha.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 스프링 시큐리티 설정들을 활성화시켜 준다.
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable() // h2-console을 사용하기 위해 해당 옵션들을 disable 한다.
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() // 전체 열람 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER만 권한 줌
                .anyRequest().authenticated() // 나머지 url들은 인증된 사용자들에게만 허용한다.
                .and()
                .logout().logoutSuccessUrl("/") // 로그아웃 성공 시 / 주소로 이동한다.
                .and()
                .oauth2Login() // oauth2 로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint() // oauth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들
                .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행할 userService의 구현체 등록
    }

}
