package br.com.aajj.ajj_backend.controller;

import br.com.aajj.ajj_backend.domain.Presence;
import br.com.aajj.ajj_backend.dto.PresenceDto;
import br.com.aajj.ajj_backend.service.PresenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/presence")
@RequiredArgsConstructor
public class PresenceController {
    private final PresenceService presenceService;

    @PostMapping
    public ResponseEntity<Presence> save(@RequestBody @Valid PresenceDto presenceDto){
        Presence presence = presenceService.save(presenceDto.getClassLessonId(), presenceDto.getUserId(), presenceDto.getStatusPresence());
        return new ResponseEntity<>(presence, HttpStatus.CREATED);
    }
}
