package br.com.aajj.ajj_backend.repository;

import br.com.aajj.ajj_backend.domain.ClassLesson;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ClassRepository extends JpaRepository<ClassLesson, Long> {
    Optional<ClassLesson> findByClassroom_IdAndLocalDate(Long id, LocalDate localDate);
}
