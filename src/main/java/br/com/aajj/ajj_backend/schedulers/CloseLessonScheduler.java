package br.com.aajj.ajj_backend.schedulers;

import br.com.aajj.ajj_backend.domain.Classroom;
import br.com.aajj.ajj_backend.repository.ClassRoomRepository;
import br.com.aajj.ajj_backend.service.ClassLessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CloseLessonScheduler {
    private final ClassRoomRepository classRoomRepository;
    private final ClassLessonService classLessonService;

    @Scheduled(fixedDelayString = "${scheduler.closeLesson.fixedDelayMs:300000}")
    public void closeLessonIfNeeded() {

        log.debug("Searching classrooms to close lessons (scheduler)");

        LocalDateTime now = LocalDateTime.now();
        List<Classroom> classrooms = classRoomRepository.findAll();

        for (Classroom classroom : classrooms) {
            try {
                LocalTime classHour = classroom.getClassHour();

                if (classHour == null) {
                    log.debug("Classroom id={} without classHour configured — skiped", classroom.getId());
                    continue;
                }

                LocalTime closingHour = classHour
                        .plusHours(1)
                        .plusMinutes(15);

                LocalDateTime closeDateTime = now.toLocalDate().atTime(closingHour);

                if (now.isAfter(closeDateTime)) {
                    log.debug("closed lesson for classroom id={} (closeTime={}, now={})",
                            classroom.getId(), closingHour, now);

                    classLessonService.closeIfOpen(classroom.getId());

                } else {
                    log.debug("this hour is not for closed classroom id={}, closeTime={} (now={})",
                            classroom.getId(), closingHour, now);
                }

            } catch (Exception e) {
                log.error("Error creating scheduler for classroom id={}: {}", classroom.getId(), e.getMessage(), e);
            }
        }
    }
}
