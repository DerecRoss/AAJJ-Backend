package br.com.aajj.ajj_backend.service;

import br.com.aajj.ajj_backend.domain.ClassLesson;
import br.com.aajj.ajj_backend.domain.StatusClass;
import br.com.aajj.ajj_backend.domain.User;
import br.com.aajj.ajj_backend.dto.OpenLessonUserDto;
import br.com.aajj.ajj_backend.repository.ClassRepository;
import br.com.aajj.ajj_backend.repository.ClassRoomRepository;
import br.com.aajj.ajj_backend.repository.PresenceRepository;
import br.com.aajj.ajj_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassLessonService {

    private final ClassRepository classRepository;
    private final ClassRoomRepository classRoomRepository;
    private final UserRepository userRepository;
    private final PresenceRepository presenceRepository;

    public ClassLesson save(Long classRoomId){
        Optional<ClassLesson> classExist = classRepository.findByClassroom_IdAndLocalDate(classRoomId, LocalDate.now());
        if (classExist.isPresent()){
            throw new RuntimeException("This lesson can't be created");
        }
        ClassLesson classLesson = new ClassLesson();
        classLesson.setLocalDate(LocalDate.now());
        classLesson.setStatusClass(StatusClass.ABERTA);
        classLesson.setClassroom(classRoomRepository.findById(classRoomId)
                .orElseThrow( () -> new RuntimeException("Classroom can't be found.")));

        return classRepository.save(classLesson);
    }
    public ClassLesson closeLesson(Long classRoomId){
       ClassLesson lesson = classRepository.findById(classRoomId)
               .orElseThrow(() -> new RuntimeException("This lesson can't be found."));

       if (lesson.getStatusClass() == StatusClass.ENCERRADA){ // lesson == closed
           return lesson;
       }

       lesson.setStatusClass(StatusClass.ENCERRADA);

       return classRepository.save(lesson);
    }

    @Transactional
    public Optional<ClassLesson> createIfNotExists(Long classRoomId){

        boolean exists = classRepository.findByClassroom_IdAndLocalDate(classRoomId, LocalDate.now()).isPresent();

        if (exists){
            log.debug("Lesson has been created for classroom id={}", classRoomId);
            return Optional.empty();
        }
        try{
            ClassLesson created = save(classRoomId);
            log.debug("Lesson created for classroom id={} (classLesson id={})", classRoomId, created.getId());
            return Optional.of(created);
        }catch (Exception e){
            log.warn("Error during create lesson for classroom id ={}: {}", classRoomId, e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<ClassLesson> closeIfOpen(Long classRoomId){
        Optional<ClassLesson> exist = classRepository.findByClassroom_IdAndLocalDate(classRoomId, LocalDate.now());

        if (exist.isEmpty()){
            log.debug("This lesson can't be found.");
            return Optional.empty();
        }

        ClassLesson classLesson = exist.get();

        if (classLesson.getStatusClass() == StatusClass.ENCERRADA){
            log.debug("This lesson has been closed");
            return Optional.empty();
        }

        classLesson.setStatusClass(StatusClass.ENCERRADA);
        classLesson = classRepository.save(classLesson);

        log.info("Lesson id={} closed successful", classRoomId);

        return Optional.of(classLesson);
    }

    public OpenLessonUserDto findOpenLessonForUser(Integer userId){
        User user = userRepository.findById(Long.valueOf(userId))
                .orElseThrow(() -> new RuntimeException("User can't be found."));

        Optional<ClassLesson> openLesson = classRepository.findByClassroom_IdAndLocalDate(
                user.getClassroom().getId(),
                LocalDate.now()
        );

        if (openLesson.isEmpty()){
            return new OpenLessonUserDto(
                    false,
                    null,
                    false,
                    "Don't have lessons for today."
            );
        }

        ClassLesson lesson = openLesson.get();

        boolean presenceExist = presenceRepository.existsByUser_IdAndClassLessonPresence_Id(Long.valueOf(userId), lesson.getId());

        return new OpenLessonUserDto(
                true,
                lesson.getId(),
                presenceExist,
                presenceExist ? "Presence has been registered" : "Lesson Open - Presence register."
        );
    }
}
