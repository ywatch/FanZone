package com.example.api1.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private boolean connect=false;
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<MessageForum> messageForum;
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
      private List<CommentaireForum> CForum;
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
      private List<CommentaireHebergement> CHebergement;
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
      private List<CommentaireStade> CStade;

}
