package org.example.keynoteservice.command.controllers;

import org.example.keynoteservice.command.commands.*;
import org.example.keynoteservice.common.dtos.CreateKeynoteRequestDTO;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/commands/keynotes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class KeynoteCommandController {

    private final CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<String> createKeynote(@RequestBody CreateKeynoteRequestDTO request) {
        String keynoteId = UUID.randomUUID().toString();
        return commandGateway.send(new CreateKeynoteCommand(
                keynoteId,
                request.getNom(),
                request.getPrenom(),
                request.getEmail(),
                request.getFonction()
        ));
    }

    @PutMapping("/{id}")
    public CompletableFuture<String> updateKeynote(
            @PathVariable String id,
            @RequestBody CreateKeynoteRequestDTO request) {
        return commandGateway.send(new UpdateKeynoteCommand(
                id,
                request.getNom(),
                request.getPrenom(),
                request.getEmail(),
                request.getFonction()
        ));
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<String> deleteKeynote(@PathVariable String id) {
        return commandGateway.send(new DeleteKeynoteCommand(id));
    }
}