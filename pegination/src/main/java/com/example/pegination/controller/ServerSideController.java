package com.example.pegination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServerSideController {

    @GetMapping("server_side")
    public String showServerSide() {
        return "server_side";
    }

}
