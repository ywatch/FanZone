package com.example.api1.service;

import com.example.api1.api.model.CommentaireHebergement;
import com.example.api1.util.comment;

import java.util.List;

public interface CommentaireHebergementService {
  public CommentaireHebergement savecomment(CommentaireHebergement c);
  public List<comment> getcommentbyidstade(String name);
  public void delete(Integer id);
  public List<CommentaireHebergement> getByName(String name);
}
