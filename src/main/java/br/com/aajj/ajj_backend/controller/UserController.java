package br.com.aajj.ajj_backend.controller;

import br.com.aajj.ajj_backend.domain.User;
import br.com.aajj.ajj_backend.dto.UserDto;
import br.com.aajj.ajj_backend.repository.UserRepository;
import br.com.aajj.ajj_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {


    private final UserRepository userRepository;

    private final UserService userService;

    @GetMapping(path = "/team")
    public ResponseEntity<List<User>> findByTeacher(@RequestParam String teacher){
        List<User> users = userService.findByTeacher(teacher);
        return ResponseEntity.ok(users);
    }

    @GetMapping(path = "/api/profile")
    @ResponseBody
    public ResponseEntity<User> getProfile(@AuthenticationPrincipal UserDetails userDetails){
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User can't be found"));
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path = "/api/profile")
    public ResponseEntity<Void> deleteProfile(@AuthenticationPrincipal UserDetails userDetails) throws BadRequestException {
        String email = userDetails.getUsername();
        userService.deleteProfile(email);
        SecurityContextHolder.clearContext();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/api/profile")
    public ResponseEntity<User> updateProfile(@AuthenticationPrincipal UserDetails userDetails, @RequestBody UserDto userDto) throws BadRequestException {
        User user = userService.update(userDetails.getUsername(), userDto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path = "/api/admin")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws BadRequestException {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
