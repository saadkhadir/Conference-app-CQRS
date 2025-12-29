package org.example.keynoteservice.query.repository;

import org.example.keynoteservice.query.entity.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeynoteRepository extends JpaRepository<Keynote, String> {
}
