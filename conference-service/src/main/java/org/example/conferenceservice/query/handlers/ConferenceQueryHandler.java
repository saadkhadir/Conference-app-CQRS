package org.example.conferenceservice.query.handlers;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.example.conferenceservice.query.entities.Conference;
import org.example.conferenceservice.query.queries.GetAllConference;
import org.example.conferenceservice.query.repository.ConferenceRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConferenceQueryHandler {

    private final ConferenceRepository conferenceRepository;

    @QueryHandler
    public List<Conference> handle(GetAllConference query) {
        return conferenceRepository.findAll();
    }
}
