package com.example.api1.service;

import com.example.api1.api.model.CommentaireStade;
import com.example.api1.repository.CommentaireStadeRepository;
import com.example.api1.util.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CommentaireStadeServiceImpl implements CommentaireStadeService {
  @Autowired
  private CommentaireStadeRepository commentaireStadeRepository;

  @Override
  public CommentaireStade savecomment(CommentaireStade c) {
    return commentaireStadeRepository.save(c);
  }

  @Override
  public List<comment> getcommentbyidstade(String name) {
    List<CommentaireStade> c = commentaireStadeRepository.findAll();
    List <comment>ret = new ArrayList<comment>();
    for (CommentaireStade c1 : c) {
      if (Objects.equals(c1.getStade().getStadename(), name)){
        ret.add(new comment(c1.getUser().getName(),c1.getContenu()));
      }
      else{
        System.out.println("Not found");
        return null;
      }
    }
    return ret;
  }

  @Override
  public void delete(Integer id) {
  commentaireStadeRepository.deleteById(id);
  }

  @Override
  public List<CommentaireStade> getByName(String name) {
    List<CommentaireStade> c = commentaireStadeRepository.findAll();
    List<CommentaireStade> c1 = new ArrayList<CommentaireStade>();
    for (CommentaireStade c2 : c) {
      if(c2.getUser().getName().equals(name)){
        c1.add(c2);
      }else {
        return null;
      }
    }
    return c1;
  }
}
