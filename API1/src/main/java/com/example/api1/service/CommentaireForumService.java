package com.example.api1.service;

import com.example.api1.api.model.CommentaireForum;
import com.example.api1.util.comment;

import java.util.List;

public interface CommentaireForumService {
  public CommentaireForum savecomment(CommentaireForum c);
  public List<comment> getcommentbycontenu(Integer id);
  public void delete(Integer id);
  public List<CommentaireForum> getByName(String name);
}
