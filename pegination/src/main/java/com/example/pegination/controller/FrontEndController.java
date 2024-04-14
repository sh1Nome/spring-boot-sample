package com.example.pegination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {

    @GetMapping("front_end")
    public String showFrontEnd() {
        return "front_end";
    }

}
