package org.example.conferenceservice.common.events;

public class ConferenceDeletedEvent {
    private String id;

    public ConferenceDeletedEvent() {}

    public ConferenceDeletedEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

