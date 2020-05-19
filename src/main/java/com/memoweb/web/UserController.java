package com.memoweb.web;

import com.memoweb.repository.user.dto.UserDto;
import com.memoweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PutMapping("/memo/login")
    public String addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);

        return "login";
    }

    @GetMapping("/memo/login")
    public ModelAndView loginGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


}
