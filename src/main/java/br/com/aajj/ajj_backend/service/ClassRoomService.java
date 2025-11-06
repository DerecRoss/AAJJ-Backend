package br.com.aajj.ajj_backend.service;

import br.com.aajj.ajj_backend.domain.Classroom;
import br.com.aajj.ajj_backend.dto.ClassRoomDto;
import br.com.aajj.ajj_backend.repository.ClassRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassRoomService {
    private final ClassRoomRepository classRoomRepository;

    public Classroom save(ClassRoomDto classRoomDto){
        Classroom classroom = new Classroom();
        classroom.setName(classRoomDto.getName());
        classroom.setClassHour(classRoomDto.getClassHour());
        classroom.setTeacher(classRoomDto.getTeacher());
        classroom.setAulas(classRoomDto.getAulas());
        return classRoomRepository.save(classroom);
    }

    public List<Classroom> findAll(){
        return classRoomRepository.findAll();
    }
}
