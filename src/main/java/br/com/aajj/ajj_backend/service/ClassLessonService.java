package br.com.aajj.ajj_backend.service;

import br.com.aajj.ajj_backend.domain.ClassLesson;
import br.com.aajj.ajj_backend.domain.StatusClass;
import br.com.aajj.ajj_backend.repository.ClassRepository;
import br.com.aajj.ajj_backend.repository.ClassRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassLessonService {

    private final ClassRepository classRepository;
    private final ClassRoomRepository classRoomRepository;

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
}
