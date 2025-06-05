package br.com.aajj.ajj_backend.dto;

import br.com.aajj.ajj_backend.domain.Charge;
import br.com.aajj.ajj_backend.domain.Time;
import br.com.aajj.ajj_backend.domain.User;
import jakarta.persistence.*;

public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Charge charge;
    private Time time;
}
