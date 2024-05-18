package com.example.api1.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class MessageForum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idm;
    private String contenu;
    private String datepublication;
    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;
  @OneToMany(mappedBy = "messageF")
    private List<CommentaireForum> CForum;

    public MessageForum(int idm, String contenu, String datepublication, User user) {
        this.idm = idm;
        this.contenu = contenu;
        this.datepublication = datepublication;
        this.user = user;
    }
    public MessageForum() {}

    public void setIdm(int idm) {
        this.idm = idm;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDatepublication(String datepublication) {
        this.datepublication = datepublication;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdm() {
        return idm;
    }

    public String getContenu() {
        return contenu;
    }

    public String getDatepublication() {
        return datepublication;
    }

    public User getUser() {
        return user;
    }
}
