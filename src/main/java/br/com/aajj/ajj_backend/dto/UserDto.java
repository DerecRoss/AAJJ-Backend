package br.com.aajj.ajj_backend.dto;

import br.com.aajj.ajj_backend.domain.Belt;
import br.com.aajj.ajj_backend.domain.Charge;
import br.com.aajj.ajj_backend.domain.Teacher;
import br.com.aajj.ajj_backend.domain.Time;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotEmpty(message = "User name can't be null or empty")
    private String name;

    private int age;

    @NotEmpty(message = "User password can't be null")
    private String password;

    @NotEmpty(message = "User email can't be null")
    private String email;

    @NotEmpty(message = "User phone can't be null")
    private String phone;

    private Teacher teacher;

    private Charge charge;

    private Time time;

    private Belt belt;
}
