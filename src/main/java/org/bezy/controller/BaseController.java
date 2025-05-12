package org.bezy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BaseController {

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String doLogin(){
        return "auth/login";
    }
}
