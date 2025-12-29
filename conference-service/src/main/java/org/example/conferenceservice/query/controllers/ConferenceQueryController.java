package org.example.conferenceservice.query.controllers;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.example.conferenceservice.query.entities.Conference;
import org.example.conferenceservice.query.queries.GetAllConference;
import org.example.conferenceservice.query.repository.ConferenceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/query/conferences")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ConferenceQueryController {

    private final QueryGateway queryGateway;
    private final ConferenceRepository conferenceRepository;

    @GetMapping
    public CompletableFuture<List<Conference>> getAllConferences() {
        return queryGateway.query(new GetAllConference(), ResponseTypes.multipleInstancesOf(Conference.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable String id) {
        return conferenceRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
