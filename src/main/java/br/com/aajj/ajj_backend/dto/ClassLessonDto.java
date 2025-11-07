package br.com.aajj.ajj_backend.dto;

import br.com.aajj.ajj_backend.domain.Classroom;
import br.com.aajj.ajj_backend.domain.Presence;
import br.com.aajj.ajj_backend.domain.StatusClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassLessonDto {

    private LocalDate localDate;

    private StatusClass statusClass;

    private Classroom classroom;

    private List<Presence> presences;
}
