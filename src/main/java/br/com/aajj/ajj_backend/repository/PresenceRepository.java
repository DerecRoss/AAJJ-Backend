package br.com.aajj.ajj_backend.repository;

import br.com.aajj.ajj_backend.domain.Presence;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PresenceRepository extends JpaRepository<Presence, Long> {
    Optional<Presence> findByClassLessonPresence_IdAndUser_Id(Long classLessonPresenceId, Long userId);
    boolean existsByUser_IdAndClassLessonPresence_Id(Long userId, Long lessonId);
}
