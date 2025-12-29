package org.example.keynoteservice.command.aggregate;

import org.example.keynoteservice.command.commands.*;
import org.example.keynoteservice.common.events.*;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
@Slf4j
public class KeynoteAggregate {

    @AggregateIdentifier
    private String keynoteId;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
    private boolean deleted;

    @CommandHandler
    public KeynoteAggregate(CreateKeynoteCommand command) {
        log.info("CreateKeynoteCommand received for: {}", command.getKeynoteId());
        AggregateLifecycle.apply(new KeynoteCreatedEvent(
                command.getKeynoteId(),
                command.getNom(),
                command.getPrenom(),
                command.getEmail(),
                command.getFonction()
        ));
    }

    @EventSourcingHandler
    public void on(KeynoteCreatedEvent event) {
        this.keynoteId = event.getKeynoteId();
        this.nom = event.getNom();
        this.prenom = event.getPrenom();
        this.email = event.getEmail();
        this.fonction = event.getFonction();
        this.deleted = false;
        log.info("Keynote created: {}", keynoteId);
    }

    @CommandHandler
    public void handle(UpdateKeynoteCommand command) {
        log.info("UpdateKeynoteCommand received for: {}", command.getKeynoteId());
        AggregateLifecycle.apply(new KeynoteUpdatedEvent(
                command.getKeynoteId(),
                command.getNom(),
                command.getPrenom(),
                command.getEmail(),
                command.getFonction()
        ));
    }

    @EventSourcingHandler
    public void on(KeynoteUpdatedEvent event) {
        this.nom = event.getNom();
        this.prenom = event.getPrenom();
        this.email = event.getEmail();
        this.fonction = event.getFonction();
        log.info("Keynote updated: {}", keynoteId);
    }

    @CommandHandler
    public void handle(DeleteKeynoteCommand command) {
        if (!this.deleted) {
            AggregateLifecycle.apply(new KeynoteDeletedEvent(command.getKeynoteId()));
        }
    }

    @EventSourcingHandler
    public void on(KeynoteDeletedEvent event) {
        this.deleted = true;
        log.info("Keynote deleted: {}", keynoteId);
    }
}