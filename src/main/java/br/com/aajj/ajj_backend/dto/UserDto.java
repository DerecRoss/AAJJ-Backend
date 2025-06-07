package br.com.aajj.ajj_backend.dto;

import br.com.aajj.ajj_backend.domain.Charge;
import br.com.aajj.ajj_backend.domain.Teacher;
import br.com.aajj.ajj_backend.domain.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Teacher teacher;
    private Charge charge;
    private Time time;
}
