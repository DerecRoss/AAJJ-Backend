package br.com.aajj.ajj_backend.controller;

import br.com.aajj.ajj_backend.domain.User;
import br.com.aajj.ajj_backend.dto.UserDto;
import br.com.aajj.ajj_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterManagerController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserDto userDto){
        userService.save(userDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
