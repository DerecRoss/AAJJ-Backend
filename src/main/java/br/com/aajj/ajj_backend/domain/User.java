package br.com.aajj.ajj_backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Charge teacher;

    @Enumerated(EnumType.STRING)
    private Charge charge;

    @Enumerated(EnumType.STRING)
    private Time time;

    @OneToMany(mappedBy = "teacher")
    private List<User> users;
}
