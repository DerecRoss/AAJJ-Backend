package br.com.aajj.ajj_backend.domain;

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
public class Class {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private LocalDate localDate;

    @Enumerated(EnumType.STRING)
    private StatusClass statusClass;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Classroom classroom;

    @OneToMany(mappedBy = "aula", cascade = CascadeType.ALL)
    private List<Presence> presences;
}
