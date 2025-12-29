package org.example.conferenceservice.query.handlers;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.example.conferenceservice.common.events.ConferenceCreatedEvent;
import org.example.conferenceservice.common.events.ConferenceDeletedEvent;
import org.example.conferenceservice.common.events.ConferenceUpdatedEvent;
import org.example.conferenceservice.query.entities.Conference;
import org.example.conferenceservice.query.repository.ConferenceRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ConferenceEventHandler {

    private final ConferenceRepository conferenceRepository;

    @EventHandler
    public void on(ConferenceCreatedEvent event) {
        Conference c = Conference.builder()
                .id(event.getId())
                .titre(event.getTitre())
                .type(event.getType())
                .date(event.getDate())
                .durationMinutes(event.getDurationMinutes())
                .nbInscrits(event.getNbInscrits())
                .score(event.getScore())
                .build();
        conferenceRepository.save(c);
    }

    @EventHandler
    public void on(ConferenceUpdatedEvent event) {
        Optional<Conference> optional = conferenceRepository.findById(event.getId());
        if (optional.isPresent()) {
            Conference c = optional.get();
            c.setTitre(event.getTitre());
            c.setType(event.getType());
            c.setDate(event.getDate());
            c.setDurationMinutes(event.getDurationMinutes());
            c.setNbInscrits(event.getNbInscrits());
            c.setScore(event.getScore());
            conferenceRepository.save(c);
        }
    }

    @EventHandler
    public void on(ConferenceDeletedEvent event) {
        conferenceRepository.deleteById(event.getId());
    }
}
