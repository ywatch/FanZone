package com.example.api1.service;

import com.example.api1.api.model.CommentaireForum;
import com.example.api1.api.model.CommentaireStade;
import com.example.api1.repository.CommentairemessageforumRepository;
import com.example.api1.repository.MessageRepository;
import com.example.api1.util.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CommentaireForumServiceImpl implements CommentaireForumService {
  @Autowired
  private CommentairemessageforumRepository commentairemessageforumRepository;
  private MessageRepository messageRepository;
  @Override
  public CommentaireForum savecomment(CommentaireForum c) {
    return commentairemessageforumRepository.save(c);
  }

  @Override
  public List<comment> getcommentbycontenu(Integer id) {
    List<CommentaireForum> c = commentairemessageforumRepository.findAll();
    List <comment>ret = new ArrayList<comment>();
    for (CommentaireForum c1 : c) {
      if (Objects.equals(c1.getMessageF().getIdm(), id)){
        ret.add(new comment(c1.getUser().getName(),c1.getContenu()));
      }
    }
    return ret; }

  @Override
  public void delete(Integer id) {
    commentairemessageforumRepository.deleteById(id);
  }

  @Override
  public List<CommentaireForum> getByName(String name) {
    return List.of();
  }
}
