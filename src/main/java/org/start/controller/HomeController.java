package org.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register/consumer")
    public String consumerRegister() {
        return "consumer/register";
    }

    @GetMapping("/register/provider")
    public String providerRegister() {
        return "provider/register";
    }
}
