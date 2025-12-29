package org.example.keynoteservice.common.events;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeynoteDeletedEvent {
    private String keynoteId;
}