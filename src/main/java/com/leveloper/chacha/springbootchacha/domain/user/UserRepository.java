package com.leveloper.chacha.springbootchacha.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.name = :name")
    Optional<User> test(@Param("name") String name);

    Optional<User> findByName(String name);
}

