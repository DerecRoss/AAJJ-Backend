package br.com.aajj.ajj_backend.repository;

import br.com.aajj.ajj_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
