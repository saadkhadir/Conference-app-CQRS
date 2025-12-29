package org.example.keynoteservice.query.handlers;

import org.example.keynoteservice.common.events.KeynoteCreatedEvent;
import org.example.keynoteservice.common.events.KeynoteDeletedEvent;
import org.example.keynoteservice.common.events.KeynoteUpdatedEvent;
import org.example.keynoteservice.query.entity.Keynote;
import org.example.keynoteservice.query.repository.KeynoteRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class KeynoteEventHandler {

    private final KeynoteRepository keynoteRepository;

    @EventHandler
    public void on(KeynoteCreatedEvent event) {
        Keynote keynote = Keynote.builder()
                .id(event.getKeynoteId())
                .nom(event.getNom())
                .prenom(event.getPrenom())
                .email(event.getEmail())
                .fonction(event.getFonction())
                .build();
        keynoteRepository.save(keynote);
    }

    @EventHandler
    public void on(KeynoteUpdatedEvent event) {
        Optional<Keynote> optional = keynoteRepository.findById(event.getKeynoteId());
        if (optional.isPresent()) {
            Keynote k = optional.get();
            k.setNom(event.getNom());
            k.setPrenom(event.getPrenom());
            k.setEmail(event.getEmail());
            k.setFonction(event.getFonction());
            keynoteRepository.save(k);
        }
    }

    @EventHandler
    public void on(KeynoteDeletedEvent event) {
        keynoteRepository.deleteById(event.getKeynoteId());
    }
}
