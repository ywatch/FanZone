package com.example.api1.api.controller;

import com.example.api1.api.model.MessageForum;
import com.example.api1.api.model.Stade;
import com.example.api1.service.MessageService;
import com.example.api1.service.imageMessageuploadService;
import com.example.api1.util.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/Message")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
  private imageMessageuploadService imageMessageuploadService;
  @Autowired
  private MessageService messageService;
  public MessageController(imageMessageuploadService imageMessageuploadService) {
    this.imageMessageuploadService = imageMessageuploadService;
  }
  @PostMapping("/add")
  public String addStade(@RequestPart("message")MessageForum m, @RequestPart("file") MultipartFile file) {
    try {
      messageService.savemessage(m);
      String filePath = imageMessageuploadService.uploadFile(file);
      m.setPathpic(filePath);
      messageService.savemessage(m);
      return "Message added; File uploaded successfully. Path: " + filePath;
    } catch (Exception e) {
      return "Failed to upload file: " + e.getMessage();
    }
  }
  @GetMapping("/all")
  public List<Posts> getAllMessages() {
    return messageService.getAllmessage();
  }
  @GetMapping("/{id}")
  public MessageForum getMessageById(@PathVariable int id) {
    return messageService.getmessagebyid(id);
  }
}
