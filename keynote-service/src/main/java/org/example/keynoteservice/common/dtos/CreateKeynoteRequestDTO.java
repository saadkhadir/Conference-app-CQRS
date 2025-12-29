package org.example.keynoteservice.common.dtos;

public class CreateKeynoteRequestDTO {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;

    public CreateKeynoteRequestDTO() {}

    public CreateKeynoteRequestDTO(String id, String nom, String prenom, String email, String fonction) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.fonction = fonction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
}
