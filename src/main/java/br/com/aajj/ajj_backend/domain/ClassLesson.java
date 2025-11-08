package br.com.aajj.ajj_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "aulas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassLesson {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate localDate;

    @Enumerated(EnumType.STRING)
    private StatusClass statusClass;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    @JsonBackReference(value = "classroom-aulas")
    private Classroom classroom;

    @OneToMany(mappedBy = "classLessonPresence")
    @JsonManagedReference(value = "lesson-presences")
    private List<Presence> presences;

}
