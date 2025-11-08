package br.com.aajj.ajj_backend.service;

import br.com.aajj.ajj_backend.domain.ClassLesson;
import br.com.aajj.ajj_backend.domain.Presence;
import br.com.aajj.ajj_backend.domain.StatusPresence;
import br.com.aajj.ajj_backend.domain.User;
import br.com.aajj.ajj_backend.repository.ClassRepository;
import br.com.aajj.ajj_backend.repository.PresenceRepository;
import br.com.aajj.ajj_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PresenceService {
    private final PresenceRepository presenceRepository;
    private final ClassRepository classRepository;
    private final UserRepository userRepository;

    @Transactional
    public Presence save(Long classLessonPresenceId, Long userId, StatusPresence statusPresence){
        ClassLesson lesson = classRepository.findById(classLessonPresenceId)
                .orElseThrow(() -> new RuntimeException("Lesson can't be found."));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User can't be found."));

        // if exist presence update.
        Optional<Presence> existence = presenceRepository.findByClassLessonPresence_IdAndUser_Id(classLessonPresenceId, userId);
        if (existence.isPresent()){
            Presence presence = existence.get();
            presence.setStatusPresence(statusPresence);
            presence.setLocalDateTime(LocalDateTime.now());
            return presenceRepository.save(presence);
        }

        Presence presence = new Presence();
        presence.setClassLessonPresence(lesson);
        presence.setUser(user);
        presence.setStatusPresence(statusPresence);
        return presenceRepository.save(presence);
    }
}
