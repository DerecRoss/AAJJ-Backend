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
public class OpenLessonScheduler {

    private final ClassRoomRepository classRoomRepository;
    private final ClassLessonService classLessonService;

    @Scheduled(fixedDelayString = "${scheduler.openLesson.fixedDelayMs:300000}")
    public void OpenLessonIfNeeded(){
        log.debug("Searching classrooms for create lessons");
        List<Classroom> classrooms = classRoomRepository.findAll();
        LocalDateTime now = LocalDateTime.now();

        for (Classroom classroom : classrooms) {
            try {
                LocalTime classHour = classroom.getClassHour();
                if (classHour == null) {
                    log.debug("Turma id={} sem classHour configurado — pulando", classroom.getId());
                    continue;
                }

                LocalDateTime startToday = now.toLocalDate().atTime(classHour);

                if (!now.isBefore(startToday)) {
                    classLessonService.createIfNotExists(classroom.getId());
                } else {
                    log.debug("Ainda não é hora da turma id={}, horario={} (now={})", classroom.getId(), classHour, now);
                }
            } catch (Exception e) {
                log.error("Erro ao processar scheduler para classroom id={}: {}", classroom.getId(), e.getMessage(), e);
            }
        }
    }
}
