package br.com.aajj.ajj_backend.controller;

import br.com.aajj.ajj_backend.domain.User;
import br.com.aajj.ajj_backend.dto.UserDto;
import br.com.aajj.ajj_backend.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RegisterManagerController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserDto userDto){
        User save = userService.save(userDto);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<User>> listAll(){
        return new ResponseEntity<>(userService.list(), HttpStatus.OK);
    }
}
