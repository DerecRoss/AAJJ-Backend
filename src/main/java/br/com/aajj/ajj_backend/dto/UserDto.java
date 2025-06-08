package br.com.aajj.ajj_backend.dto;

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

    @NotEmpty(message = "User name can't be null")
    private String name;

    @NotEmpty(message = "User name can't be null")
    private String password;

    @NotEmpty(message = "User name can't be null")
    private String email;

    @NotEmpty(message = "User name can't be null")
    private String phone;

    private Teacher teacher;

    private Charge charge;

    private Time time;
}
