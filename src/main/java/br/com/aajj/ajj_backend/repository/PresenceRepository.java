package br.com.aajj.ajj_backend.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenceRepository extends JpaRepository<Long, Id> {
}
