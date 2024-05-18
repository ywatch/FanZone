package com.example.api1.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CommentaireHebergement {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idCommentaire;
    private String Contenu;
    private String Datep;
  @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;
  @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "hebe_id")
    private Hebergement hebe;
}
