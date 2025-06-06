package br.com.aajj.ajj_backend.service;

import br.com.aajj.ajj_backend.domain.User;
import br.com.aajj.ajj_backend.dto.UserDto;
import br.com.aajj.ajj_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(UserDto userDto){
        User user = new User();
        user.setName(user.getName());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setPhone(user.getPhone());
        user.setTeacher(user.getTeacher());
        user.setCharge(user.getCharge());
        user.setTime(user.getTime());

        return userRepository.save(user);
    }

}
