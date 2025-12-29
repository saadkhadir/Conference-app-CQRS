package org.example.keynoteservice.query.controller;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.example.keynoteservice.query.entity.Keynote;
import org.example.keynoteservice.query.queries.GetAllKeynotes;
import org.example.keynoteservice.query.repository.KeynoteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/query/keynotes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class KeynoteQueryController {

    private final QueryGateway queryGateway;
    private final KeynoteRepository keynoteRepository;

    @GetMapping
    public CompletableFuture<List<Keynote>> getAllKeynotes() {
        return queryGateway.query(new GetAllKeynotes(), ResponseTypes.multipleInstancesOf(Keynote.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Keynote> getKeynoteById(@PathVariable String id) {
        return keynoteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
