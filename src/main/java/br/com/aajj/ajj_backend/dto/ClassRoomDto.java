package br.com.aajj.ajj_backend.dto;

import br.com.aajj.ajj_backend.domain.ClassLesson;
import br.com.aajj.ajj_backend.domain.Teacher;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomDto {

    private LocalTime classHour;

    @NotEmpty(message = "Classroom name can't be null")
    private String name;

    private Teacher teacher;

    private List<ClassLesson> aulas;
}
