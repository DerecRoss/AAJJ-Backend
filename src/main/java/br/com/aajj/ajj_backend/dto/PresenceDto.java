package br.com.aajj.ajj_backend.dto;

import br.com.aajj.ajj_backend.domain.ClassLesson;
import br.com.aajj.ajj_backend.domain.StatusPresence;
import br.com.aajj.ajj_backend.domain.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresenceDto {

    private Long classLessonId;

    @NotNull
    private Long userId;

    @NotNull
    private StatusPresence statusPresence;

    private LocalDateTime localDateTime;
}
