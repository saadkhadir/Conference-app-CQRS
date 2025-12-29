package org.example.conferenceservice.command.commands;

import org.example.conferenceservice.common.enums.ConferenceType;

import java.time.LocalDateTime;

public class CreateConferenceCommand {
    private String id;
    private String titre;
    private ConferenceType type;
    private LocalDateTime date;
    private int durationMinutes;
    private int nbInscrits;
    private double score;

    public CreateConferenceCommand() {}

    public CreateConferenceCommand(String id, String titre, ConferenceType type, LocalDateTime date, int durationMinutes, int nbInscrits, double score) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.date = date;
        this.durationMinutes = durationMinutes;
        this.nbInscrits = nbInscrits;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public ConferenceType getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public int getNbInscrits() {
        return nbInscrits;
    }

    public double getScore() {
        return score;
    }
}
