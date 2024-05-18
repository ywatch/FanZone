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
public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Sid;
    private String Stadename;
    private String Ville;
    private int capacite;
    private String Pathpic;
    @JsonManagedReference
    @OneToMany(mappedBy = "stade")
      private List<CommentaireStade> CStade;
}
