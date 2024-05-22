package com.example.api1.api.controller;

import com.example.api1.api.model.CommentaireForum;
import com.example.api1.api.model.CommentaireHebergement;
import com.example.api1.service.CommentaireForumService;
import com.example.api1.util.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CommentairemessageForum")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentairemessageForumController {
  @Autowired
  CommentaireForumService commentaireForumService;
  @PostMapping("/add")
  public String add(@RequestBody CommentaireForum c) {
    commentaireForumService.savecomment(c);
    return "new comment is added";
  }
  @GetMapping("/{id}")
  public List<comment> getAll(@PathVariable Integer id) {
    return commentaireForumService.getcommentbycontenu(id);
  }
}
