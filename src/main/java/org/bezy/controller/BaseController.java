package org.bezy.controller;

import org.bezy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String doLogin(){
        return "auth/login";
    }

    // Hotel Block

    @GetMapping("/services/hotels")
    public String redirectToHotels() {
        return "redirect:/show/hotels";
    }

    @GetMapping("/show/hotels")
    public String showHotels(){
        return "services/hotel";
    }


    // Flight Block

    @GetMapping("/services/flights")
    public String redirectToFlights(){
        return "redirect:/show/flights";
    }

    @GetMapping("/show/flights")
    public String showFlights(){
        return "/services/flights";
    }


    // Taxi Block

    @GetMapping("/services/taxis")
    public String redirectToTaxis(){
        return "redirect:/show/taxis";
    }

    @GetMapping("/show/taxis")
    public String showTaxis(){
        return "/services/taxi";
    }


    // Car Rental Block

    @GetMapping("/services/car-rentals")
    public String redirectToCarRental(){
        return "redirect:/show/rentals";
    }

    @GetMapping("/show/rentals")
    public String showRental(){
        return "/services/car_rentals";
    }
}
