package br.com.aajj.ajj_backend.dto;

import br.com.aajj.ajj_backend.domain.Class;
import br.com.aajj.ajj_backend.domain.Teacher;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class ClassRoomDto {

    private Integer id;

    private LocalTime classHour;

    @NotEmpty(message = "Classroom name can't be null")
    private String name;

    @NotEmpty(message = "Classroom Teacher can't be null")
    private Teacher professor;

    private List<Class> aulas;
}
