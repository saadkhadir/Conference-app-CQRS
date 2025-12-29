package org.example.keynoteservice.query.handlers;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.example.keynoteservice.query.entity.Keynote;
import org.example.keynoteservice.query.queries.GetAllKeynotes;
import org.example.keynoteservice.query.repository.KeynoteRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class KeynoteQueryHandler {

    private final KeynoteRepository keynoteRepository;

    @QueryHandler
    public List<Keynote> handle(GetAllKeynotes query) {
        return keynoteRepository.findAll();
    }
}
