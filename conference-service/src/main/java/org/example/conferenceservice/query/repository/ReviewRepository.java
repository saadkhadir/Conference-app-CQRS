package org.example.conferenceservice.query.repository;

import org.example.conferenceservice.query.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, String> {
}
