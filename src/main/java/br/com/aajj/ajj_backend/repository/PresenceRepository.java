package br.com.aajj.ajj_backend.repository;

import br.com.aajj.ajj_backend.domain.Presence;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenceRepository extends JpaRepository<Presence, Id> {
}
