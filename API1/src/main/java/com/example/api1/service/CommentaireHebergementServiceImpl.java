package com.example.api1.service;
import com.example.api1.api.model.CommentaireHebergement;
import com.example.api1.repository.CommentaireHebergementRepository;
import com.example.api1.util.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CommentaireHebergementServiceImpl implements CommentaireHebergementService {
  @Autowired
  private CommentaireHebergementRepository commentaireHebergementRepository;

  @Override
  public CommentaireHebergement savecomment(CommentaireHebergement c) {
    return commentaireHebergementRepository.save(c);
  }

  @Override
  public List<comment> getcommentbyidstade(String name) {
    List<CommentaireHebergement> c = commentaireHebergementRepository.findAll();
    List <comment>ret = new ArrayList<comment>();
    for (CommentaireHebergement c1 : c) {
      if (Objects.equals(c1.getHebe().getHname(), name)){
        ret.add(new comment(c1.getUser().getName(),c1.getContenu()));
      }
      else{
        System.out.println("Not found");
        return null;
      }
    }
    return ret;  }

  @Override
  public void delete(Integer id) {
    commentaireHebergementRepository.deleteById(id);
  }

  @Override
  public List<CommentaireHebergement> getByName(String name) {
    return List.of();
  }
}
