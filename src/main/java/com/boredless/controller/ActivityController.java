package com.boredless.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {

    @GetMapping("/test")
    public String getActivity() {
        return "hello world!";
    }
}
