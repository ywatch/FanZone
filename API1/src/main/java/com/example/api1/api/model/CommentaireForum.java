package com.example.api1.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class CommentaireForum {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idCommentaire;
    private String Contenu;
    private String Datep;

    @ManyToOne
    @JoinColumn(name = "User_id")
    @JsonBackReference("user-cforum")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Message_id")
    @JsonBackReference("message-commentaire")
    private MessageForum messageF;

    public CommentaireForum(Integer idCommentaire, String contenu, String datep, User user, MessageForum messageF) {
        this.idCommentaire = idCommentaire;
        Contenu = contenu;
        Datep = datep;
        this.user = user;
        this.messageF = messageF;
    }

    public CommentaireForum() {

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

    public void setMessageF(MessageForum messageF) {
        this.messageF = messageF;
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

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public MessageForum getMessageF() {
        return messageF;
    }
}
