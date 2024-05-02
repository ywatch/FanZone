package com.example.api1.api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Sid;
    private String Stadename;
    private String Ville;
    private int capacite;
    @OneToMany(mappedBy = "stade")
    private List<CommentaireStade> CStade;
    public Stade() {
    }

    public Stade(int sid, String stadename, String ville, int capacite) {
        Sid = sid;
        Stadename = stadename;
        Ville = ville;
        this.capacite = capacite;
    }

    public void setSid(int sid) {
        Sid = sid;
    }

    public void setStadename(String stadename) {
        Stadename = stadename;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getSid() {
        return Sid;
    }

    public String getStadename() {
        return Stadename;
    }

    public String getVille() {
        return Ville;
    }

    public int getCapacite() {
        return capacite;
    }
}
