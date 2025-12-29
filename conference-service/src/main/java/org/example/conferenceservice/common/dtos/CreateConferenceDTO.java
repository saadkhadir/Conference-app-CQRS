package org.example.conferenceservice.common.dtos;

import java.time.LocalDateTime;

public class CreateConferenceDTO {
    private String id;
    private String titre;
    private String type; // ConferenceType as String in DTO
    private LocalDateTime date;
    private int durationMinutes;
    private int nbInscrits;
    private double score;

    public CreateConferenceDTO() {}

    public CreateConferenceDTO(String id, String titre, String type, LocalDateTime date, int durationMinutes, int nbInscrits, double score) {
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

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getNbInscrits() {
        return nbInscrits;
    }

    public void setNbInscrits(int nbInscrits) {
        this.nbInscrits = nbInscrits;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
