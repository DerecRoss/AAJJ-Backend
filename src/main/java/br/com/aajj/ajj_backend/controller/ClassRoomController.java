package br.com.aajj.ajj_backend.controller;

import br.com.aajj.ajj_backend.domain.Classroom;
import br.com.aajj.ajj_backend.dto.ClassRoomDto;
import br.com.aajj.ajj_backend.repository.ClassRoomRepository;
import br.com.aajj.ajj_backend.service.ClassRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classroom")
public class ClassRoomController {
    private final ClassRoomService classRoomService;

    @PostMapping
    public ResponseEntity<Classroom> save(@RequestBody @Valid ClassRoomDto classRoomDto){
        Classroom classroom = classRoomService.save(classRoomDto);
        return new ResponseEntity<>(classroom, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Classroom>> findALl(){
        List<Classroom> all = classRoomService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
