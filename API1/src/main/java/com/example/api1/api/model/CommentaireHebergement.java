package com.example.api1.api.model;

import jakarta.persistence.*;

@Entity
public class CommentaireHebergement {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idCommentaire;
    private String Contenu;
    private String Datep;
    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "hebe_id")
    private Hebergement hebe;

    public CommentaireHebergement() {
    }

    public CommentaireHebergement(Integer idCommentaire, String contenu, String datep, User user, Hebergement hebe) {
        this.idCommentaire = idCommentaire;
        Contenu = contenu;
        Datep = datep;
        this.user = user;
        this.hebe = hebe;
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

    public void setHebe(Hebergement hebe) {
        this.hebe = hebe;
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

    public Hebergement getHebe() {
        return hebe;
    }
}
