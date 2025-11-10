package br.com.aajj.ajj_backend.controller;

import br.com.aajj.ajj_backend.domain.ClassLesson;
import br.com.aajj.ajj_backend.dto.OpenLessonDto;
import br.com.aajj.ajj_backend.service.ClassLessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class ClassLessonController {

    public final ClassLessonService classLessonService;

    @PostMapping
    public ResponseEntity<ClassLesson> save(@RequestBody OpenLessonDto openLessonDto){
        ClassLesson classLesson = classLessonService.save(openLessonDto.getClassroom());
        return new ResponseEntity<>(classLesson, HttpStatus.CREATED);
    }

    @PutMapping("/lesson/{id}/close")
    public ResponseEntity<ClassLesson> closeLesson(@PathVariable Long id){
        ClassLesson classLesson = classLessonService.closeLesson(id);
        return new ResponseEntity<>(classLesson, HttpStatus.OK);
    }
}
