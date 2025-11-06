package br.com.aajj.ajj_backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "turmas")
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private LocalTime classHour;

    private String name;

    @Enumerated(EnumType.STRING)
    private Teacher professor;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Class> aulas;

}
