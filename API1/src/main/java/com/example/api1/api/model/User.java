package com.example.api1.api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<MessageForum> messageForum;
    @OneToMany(mappedBy = "user")
    private List<CommentaireForum> CForum;
    @OneToMany(mappedBy = "user")
    private List<CommentaireHebergement> CHebergement;
    @OneToMany(mappedBy = "user")
    private List<CommentaireStade> CStade;
    public User() {}

    public User(int id, String name, String email, String password, List<MessageForum> messageForum, List<CommentaireForum> CForum, List<CommentaireHebergement> CHebergement, List<CommentaireStade> CStade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.messageForum = messageForum;
        this.CForum = CForum;
        this.CHebergement = CHebergement;
        this.CStade = CStade;
    }

    public List<CommentaireForum> getCForum() {
        return CForum;
    }

    public void setCForum(List<CommentaireForum> CForum) {
        this.CForum = CForum;
    }

    public List<CommentaireHebergement> getCHebergement() {
        return CHebergement;
    }

    public void setCHebergement(List<CommentaireHebergement> CHebergement) {
        this.CHebergement = CHebergement;
    }

    public List<CommentaireStade> getCStade() {
        return CStade;
    }

    public void setCStade(List<CommentaireStade> CStade) {
        this.CStade = CStade;
    }

    public void setMessageForum(List<MessageForum> messageForum) {
        this.messageForum = messageForum;
    }

    public List<MessageForum> getMessageForum() {
        return messageForum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
