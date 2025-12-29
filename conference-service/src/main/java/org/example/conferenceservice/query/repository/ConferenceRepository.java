package org.example.conferenceservice.query.repository;

import org.example.conferenceservice.query.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, String> {
}
