package com.memoweb.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class LoginController {

    @GetMapping("/memo/login")
    public ModelAndView loginGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/memo/login")
    public ModelAndView loginPost() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");

        return modelAndView;
    }
}
