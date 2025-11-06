package br.com.aajj.ajj_backend.domain;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "presencas")
public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private ClassLesson classLessonPresence;

    @ManyToOne
    @JoinColumn(name = "user_tb")
    private User user;

    @Enumerated(EnumType.STRING)
    private StatusPresence statusPresence; // PRESENTE, FALTOU, PENDENTE

    private LocalDateTime localDateTime;

}
