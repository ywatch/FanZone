package com.example.api1.api.controller;

import com.example.api1.api.model.CommentaireHebergement;
import com.example.api1.api.model.CommentaireStade;
import com.example.api1.service.CommentaireHebergementService;
import com.example.api1.util.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CommentaireHebergement")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentaireHebergementController {
  @Autowired
  private CommentaireHebergementService commentaireHebergementService;
  @PostMapping("/add")
  public String add(@RequestBody CommentaireHebergement c) {
    commentaireHebergementService.savecomment(c);
    return "new comment is added";
  }
  @GetMapping("/{name}")
  public List<comment> getAll(@PathVariable String name) {
    return commentaireHebergementService.getcommentbyidstade(name);
  }

}
