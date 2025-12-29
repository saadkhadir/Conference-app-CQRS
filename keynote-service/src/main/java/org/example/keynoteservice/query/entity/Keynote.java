package org.example.keynoteservice.query.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Keynote {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;

}
