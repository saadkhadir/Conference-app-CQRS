package org.example.conferenceservice.query.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    private String id;

    private LocalDateTime date;

    @Column(length = 2000)
    private String texte;

    // stars between 1 and 5
    private int stars;

    @ManyToOne(fetch = FetchType.LAZY)
    private Conference conference;
}