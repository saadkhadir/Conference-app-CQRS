package org.example.conferenceservice.query.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.conferenceservice.common.enums.ConferenceType;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conference {
    @Id
    private String id;

    private String titre;

    @Enumerated(EnumType.STRING)
    private ConferenceType type;
    private LocalDateTime date;
    // duration in minutes
    private int durationMinutes;
    private int nbInscrits;
    private double score;

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Review> reviews = new ArrayList<>();


}