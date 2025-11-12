package br.com.aajj.ajj_backend.repository;

import br.com.aajj.ajj_backend.domain.Classroom;
import br.com.aajj.ajj_backend.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.Optional;

public interface ClassRoomRepository extends JpaRepository<Classroom, Long> {
    Optional<Teacher> findByTeacher(Teacher teacher);
    Optional<Classroom> findByTeacherAndClassHour(Teacher teacher, LocalTime classHour);
}
