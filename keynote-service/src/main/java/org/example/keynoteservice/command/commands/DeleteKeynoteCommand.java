package org.example.keynoteservice.command.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class DeleteKeynoteCommand {
    @TargetAggregateIdentifier
    private String keynoteId;
}
