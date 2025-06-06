package br.com.aajj.ajj_backend.service;

import br.com.aajj.ajj_backend.domain.User;
import br.com.aajj.ajj_backend.dto.UserDto;
import br.com.aajj.ajj_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setTeacher(userDto.getTeacher());
        user.setCharge(userDto.getCharge());
        user.setTime(userDto.getTime());

       return userRepository.save(user);
    }

    public List<User> list(){
        return userRepository.findAll();
    }
}
