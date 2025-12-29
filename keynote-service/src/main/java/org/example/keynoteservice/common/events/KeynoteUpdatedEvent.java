package org.example.keynoteservice.common.events;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeynoteUpdatedEvent {
    private String keynoteId;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}
