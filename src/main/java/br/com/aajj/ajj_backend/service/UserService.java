package br.com.aajj.ajj_backend.service;

import br.com.aajj.ajj_backend.domain.Teacher;
import br.com.aajj.ajj_backend.domain.User;
import br.com.aajj.ajj_backend.dto.UserDto;
import br.com.aajj.ajj_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User save(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setTeacher(userDto.getTeacher());
        user.setCharge(userDto.getCharge());
        user.setTime(userDto.getTime());
        user.setBelt(userDto.getBelt());

       return userRepository.save(user);
    }

    public Page<User> list(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public List<User> listAllNoPageable(){
        return userRepository.findAll();
    }

    public List<User> findByTeacher(String teacher){
        return userRepository.findByTeacher(Teacher.valueOf(teacher.toUpperCase()));
    }
}
