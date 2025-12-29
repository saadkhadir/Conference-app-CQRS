package org.example.conferenceservice.command.controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.example.conferenceservice.command.commands.CreateConferenceCommand;
import org.example.conferenceservice.command.commands.DeleteConferenceCommand;
import org.example.conferenceservice.command.commands.UpdateConferenceCommand;
import org.example.conferenceservice.common.dtos.CreateConferenceDTO;
import org.example.conferenceservice.common.enums.ConferenceType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/command/conferences")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ConferenceCommandController {

    private final CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<String> createConference(@RequestBody CreateConferenceDTO dto) {
        String id = dto.getId() == null || dto.getId().isBlank() ? UUID.randomUUID().toString() : dto.getId();
        CreateConferenceCommand cmd = new CreateConferenceCommand(
                id,
                dto.getTitre(),
                dto.getType() != null ? ConferenceType.valueOf(dto.getType()) : null,
                dto.getDate(),
                dto.getDurationMinutes(),
                dto.getNbInscrits(),
                dto.getScore()
        );
        return commandGateway.send(cmd);
    }

    @PutMapping("/{id}")
    public CompletableFuture<String> updateConference(@PathVariable String id, @RequestBody CreateConferenceDTO dto) {
        UpdateConferenceCommand cmd = new UpdateConferenceCommand(
                id,
                dto.getTitre(),
                dto.getType() != null ? ConferenceType.valueOf(dto.getType()) : null,
                dto.getDate(),
                dto.getDurationMinutes(),
                dto.getNbInscrits(),
                dto.getScore()
        );
        return commandGateway.send(cmd);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<String> deleteConference(@PathVariable String id) {
        DeleteConferenceCommand cmd = new DeleteConferenceCommand(id);
        return commandGateway.send(cmd);
    }
}
