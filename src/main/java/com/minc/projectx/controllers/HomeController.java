package com.minc.projectx.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping(value="home")
    public String home(){
        return "Home page";
    }

    @GetMapping(value="admin")
    public String admiin(){
        return "Admin page";
    }


}


