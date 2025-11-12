package br.com.aajj.ajj_backend.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "turma")
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalTime classHour;

    private String name;

    @Enumerated(EnumType.STRING)
    private Teacher teacher;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "classroom-aulas")
    private List<ClassLesson> aulas;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-classroom")
    private List<User> users;

}
