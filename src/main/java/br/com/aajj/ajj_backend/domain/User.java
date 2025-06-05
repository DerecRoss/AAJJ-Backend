package br.com.aajj.ajj_backend.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Charge charge;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @Enumerated(EnumType.STRING)
    private Time time;

    @OneToMany(mappedBy = "teacher")
    private List<User> users;
}
