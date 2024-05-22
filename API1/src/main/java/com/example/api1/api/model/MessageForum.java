package com.example.api1.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MessageForum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idm;
    private String contenu;
    private String datepublication;
    private String Pathpic;

  @ManyToOne
    @JoinColumn(name = "User_id")
    @JsonBackReference("user-message")
    private User user;

    @OneToMany(mappedBy = "messageF")
    @JsonManagedReference("message-commentaire")
    private List<CommentaireForum> CForum;

}
