package br.com.aajj.ajj_backend.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "presencas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    @JsonBackReference(value = "lesson-presences")
    private ClassLesson classLessonPresence;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private StatusPresence statusPresence; // PRESENTE, FALTOU, PENDENTE

    private LocalDateTime localDateTime;

}
