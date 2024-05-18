package com.example.api1.service;

import com.example.api1.util.comment;
import com.example.api1.api.model.CommentaireStade;

import java.util.List;

public interface CommentaireStadeService {
  public CommentaireStade savecomment(CommentaireStade c);
  public List<comment> getcommentbyidstade(String name);
  public void delete(Integer id);
  public List<CommentaireStade> getByName(String name);
}
