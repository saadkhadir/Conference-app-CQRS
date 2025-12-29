package org.example.keynoteservice.command.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class CreateKeynoteCommand {
    @TargetAggregateIdentifier
    private String keynoteId;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}