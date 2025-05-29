package org.bezy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ExploreController {

    @GetMapping("/explore/tokyo")
    public String exploreServiceTokyo(){
        return "/services/destinations/tokyo";
    }

    @GetMapping("/explore/new-york")
    public String exploreServiceNewYork(){
        return "/services/destinations/new_york";
    }

    @GetMapping("/explore/paris")
    public String exploreServiceParis(){
        return "/services/destinations/paris";
    }
}
