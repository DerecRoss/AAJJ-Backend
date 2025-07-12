package br.com.aajj.ajj_backend.service;

import br.com.aajj.ajj_backend.domain.Teacher;
import br.com.aajj.ajj_backend.domain.User;
import br.com.aajj.ajj_backend.dto.UserDto;
import br.com.aajj.ajj_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
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

    public User update(String email, UserDto userDtoUpdateData) throws BadRequestException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new BadRequestException("user cant be found"));
        user.setName(userDtoUpdateData.getName());
        user.setAge(userDtoUpdateData.getAge());
        user.setPhone(userDtoUpdateData.getPhone());
        user.setTeacher(userDtoUpdateData.getTeacher());
        user.setTime(userDtoUpdateData.getTime());
        user.setBelt(userDtoUpdateData.getBelt());
        return userRepository.save(user);
    }

    public User findByIdOrThrowBadRequestException(Long id) throws BadRequestException {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("user not found"));
    }

    public void delete(Long id) throws BadRequestException {
        userRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void deleteProfile(String email) throws BadRequestException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("User not found"));
        userRepository.delete(user);
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    public Page<User> list(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @PreAuthorize("hasRole('PROFESSOR')")
    public List<User> listAllNoPageable(){
        return userRepository.findAll();
    }

    public List<User> findByTeacher(String teacher){
        return userRepository.findByTeacher(Teacher.valueOf(teacher.toUpperCase()));
    }
}
