package com.cslink.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class CoreController {
    @GetMapping("/core")
    public String coreTest() {
        return "Hi! Core";
    }
}
