package com.example.pegination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueJsController {

    @GetMapping("vue_js")
    public String showVueJs() {
        return "vue_js";
    }

}
