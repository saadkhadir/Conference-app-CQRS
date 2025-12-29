package org.example.conferenceservice.command.commands;

public class DeleteConferenceCommand {
    private String id;

    public DeleteConferenceCommand() {}

    public DeleteConferenceCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
