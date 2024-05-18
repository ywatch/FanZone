package com.example.api1.api.controller;

import com.example.api1.api.model.CommentaireStade;
import com.example.api1.api.model.User;
import com.example.api1.service.CommentaireStadeService;
import com.example.api1.util.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CommentaireStade")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentaireStadeController {
  @Autowired
  CommentaireStadeService commentaireStadeService;
  @PostMapping("/add")
  public String add(@RequestBody CommentaireStade c) {
    commentaireStadeService.savecomment(c);
    return "new comment is added";
  }
  @GetMapping("/{name}")
  public List<comment> getAll(@PathVariable String name) {
    return commentaireStadeService.getcommentbyidstade(name);
  }
}
