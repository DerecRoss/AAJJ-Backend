package br.com.aajj.ajj_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String indexRedirect(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(){
        return "home"; // search home in directories -> templates -> home.html
    }

    @GetMapping("/register")
    public String signup(){
        return "signup";
    }

    @GetMapping("/login")
    public String login(){
        return "signup";
    }

}
