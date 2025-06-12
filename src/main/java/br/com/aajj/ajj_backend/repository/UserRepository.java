package br.com.aajj.ajj_backend.repository;

import br.com.aajj.ajj_backend.domain.Teacher;
import br.com.aajj.ajj_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByTeacher(Teacher teacher);
    Optional<User> findByEmail(String email);
}
