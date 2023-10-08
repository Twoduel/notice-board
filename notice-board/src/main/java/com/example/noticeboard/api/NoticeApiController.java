package com.example.noticeboard.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeApiController {
    @GetMapping("/api/hello")
    public String hello(){
        return "hello!";
    }
}
