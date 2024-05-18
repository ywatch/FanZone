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
public class Hebergement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hid;
    private String hname;
    private String hadd;
    private double hprice;
    private String Pathpic;
  @JsonManagedReference
  @OneToMany(mappedBy = "hebe")
    private List<CommentaireHebergement> CHebergement;
}
