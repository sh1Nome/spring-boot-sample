package com.example.pegination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringPageable {

    @GetMapping("spring_pageable")
    public String showSpringPageable() {
        return "spring_pageable";
    }

}
