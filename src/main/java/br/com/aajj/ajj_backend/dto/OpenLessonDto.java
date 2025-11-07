package br.com.aajj.ajj_backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OpenLessonDto {
    @NotNull
    private Long classroom;
}
