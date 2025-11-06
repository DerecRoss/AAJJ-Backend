package br.com.aajj.ajj_backend.repository;

import br.com.aajj.ajj_backend.domain.Classroom;
import br.com.aajj.ajj_backend.domain.Teacher;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRoomRepository extends JpaRepository<Classroom, Id> {
    Optional<Teacher> findByTeacher(Teacher teacher);
}
