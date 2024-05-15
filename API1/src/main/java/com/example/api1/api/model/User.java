package com.example.api1.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private boolean connect;
    @OneToMany(mappedBy = "user")
    private List<MessageForum> messageForum;
    @OneToMany(mappedBy = "user")
    private List<CommentaireForum> CForum;
    @OneToMany(mappedBy = "user")
    private List<CommentaireHebergement> CHebergement;
    @OneToMany(mappedBy = "user")
    private List<CommentaireStade> CStade;

}
