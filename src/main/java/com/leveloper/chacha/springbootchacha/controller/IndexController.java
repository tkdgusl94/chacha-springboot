package com.leveloper.chacha.springbootchacha.controller;

import com.leveloper.chacha.springbootchacha.config.auth.LoginUser;
import com.leveloper.chacha.springbootchacha.config.auth.dto.SessionUser;
import com.leveloper.chacha.springbootchacha.controller.dto.BookResponseDto;
import com.leveloper.chacha.springbootchacha.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ItemService itemService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/items/new")
    public String createItem(Model model, @LoginUser SessionUser user){
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "items/createItem";
    }

    @GetMapping("/items/{id}")
    public String detailItem(@PathVariable Long id, Model model, @LoginUser SessionUser user){
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        BookResponseDto responseDto = itemService.findById(id);

        model.addAttribute("item", responseDto);
        return "items/detailItem";
    }
}
