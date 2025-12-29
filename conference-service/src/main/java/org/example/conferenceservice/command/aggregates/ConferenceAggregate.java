package org.example.conferenceservice.command.aggregates;

import org.example.conferenceservice.command.commands.CreateConferenceCommand;
import org.example.conferenceservice.command.commands.UpdateConferenceCommand;
import org.example.conferenceservice.command.commands.DeleteConferenceCommand;
import org.example.conferenceservice.common.events.ConferenceCreatedEvent;
import org.example.conferenceservice.common.events.ConferenceUpdatedEvent;
import org.example.conferenceservice.common.events.ConferenceDeletedEvent;
import org.example.conferenceservice.common.enums.ConferenceType;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;

import java.time.LocalDateTime;

@Aggregate
public class ConferenceAggregate {

    @AggregateIdentifier
    private String id;
    private String titre;
    private ConferenceType type;
    private LocalDateTime date;
    private int durationMinutes;
    private int nbInscrits;
    private double score;

    public ConferenceAggregate() {}

    @CommandHandler
    public ConferenceAggregate(CreateConferenceCommand command) {
        ConferenceCreatedEvent event = new ConferenceCreatedEvent(
                command.getId(),
                command.getTitre(),
                command.getType(),
                command.getDate(),
                command.getDurationMinutes(),
                command.getNbInscrits(),
                command.getScore()
        );
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateConferenceCommand command) {
        ConferenceUpdatedEvent event = new ConferenceUpdatedEvent(
                command.getId(),
                command.getTitre(),
                command.getType(),
                command.getDate(),
                command.getDurationMinutes(),
                command.getNbInscrits(),
                command.getScore()
        );
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteConferenceCommand command) {
        AggregateLifecycle.apply(new ConferenceDeletedEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(ConferenceCreatedEvent event) {
        this.id = event.getId();
        this.titre = event.getTitre();
        this.type = event.getType();
        this.date = event.getDate();
        this.durationMinutes = event.getDurationMinutes();
        this.nbInscrits = event.getNbInscrits();
        this.score = event.getScore();
    }

    @EventSourcingHandler
    public void on(ConferenceUpdatedEvent event) {
        this.titre = event.getTitre();
        this.type = event.getType();
        this.date = event.getDate();
        this.durationMinutes = event.getDurationMinutes();
        this.nbInscrits = event.getNbInscrits();
        this.score = event.getScore();
    }

    @EventSourcingHandler
    public void on(ConferenceDeletedEvent event) {
        // mark the aggregate as deleted so Axon clears it from the repository
        AggregateLifecycle.markDeleted();
    }
}
