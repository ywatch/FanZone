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
    @OneToMany(mappedBy = "user")
    @JsonManagedReference("user-message")
    private List<MessageForum> messageForum;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference("user-cforum")
    private List<CommentaireForum> CForum;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference("user-chebergement")
    private List<CommentaireHebergement> CHebergement;
    @OneToMany(mappedBy = "user")
    @JsonManagedReference("user-cstade")
    private List<CommentaireStade> CStade;

}
