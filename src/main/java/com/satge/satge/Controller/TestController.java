package com.satge.satge.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/ping")
    public String ping() {
        System.out.println("alive");
        return "ping";
    }

    @PostMapping("/pong")
    public String pong() {
        System.out.println("alive");
        return "pong";
    }
}