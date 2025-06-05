package br.com.aajj.ajj_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping(path = "/dev")
    public void hello(){
        System.out.println("Olá, Mundo!");
    }
}
