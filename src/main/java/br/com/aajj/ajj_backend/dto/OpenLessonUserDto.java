package br.com.aajj.ajj_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenLessonUserDto {

    private boolean lessonOpen;

    private Long classLessonId;

    protected boolean presenceDone;

    private String message;

}
