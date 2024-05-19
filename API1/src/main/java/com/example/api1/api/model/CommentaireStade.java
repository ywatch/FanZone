package com.example.api1.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
public class CommentaireStade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCommentaire;
    private String Contenu;
    private String Datep;
    @ManyToOne
    @JoinColumn(name = "User_id")
    @JsonBackReference("user-cstade")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Stade_id")
    @JsonBackReference("Stade-commentaire")
    private Stade stade;

    public CommentaireStade(Integer idCommentaire, String contenu, String datep, User user, Stade stade) {
        this.idCommentaire = idCommentaire;
        Contenu = contenu;
        Datep = datep;
        this.user = user;
        this.stade = stade;
    }

    public CommentaireStade() {

    }

    public void setIdCommentaire(Integer idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    public void setDatep(String datep) {
        Datep = datep;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public Integer getIdCommentaire() {
        return idCommentaire;
    }

    public String getContenu() {
        return Contenu;
    }

    public String getDatep() {
        return Datep;
    }

    public User getUser() {
        return user;
    }

    public Stade getStade() {
        return stade;
    }
}
