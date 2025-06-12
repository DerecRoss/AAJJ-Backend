package br.com.aajj.ajj_backend.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

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
        return "login";
    }

    @GetMapping("/team")
    public String profile(){
        return "team";
    }

    @GetMapping("/redirect-role-based")
    public String redirectRoleBased(Authentication authentication){
        if (authentication.getAuthorities().stream().anyMatch( a ->
                a.getAuthority().equals("PROFESSOR"))){
            return "redirect:/team";
        }
        return "redirect:/profile";
    }

}
