package com.example.api1.service;


import com.example.api1.api.model.MessageForum;
import com.example.api1.util.Posts;

import java.util.List;

public interface MessageService {
  public MessageForum savemessage(MessageForum m);
  public List<Posts> getAllmessage();
  public MessageForum getmessagebyid(int id);
  public void delete(Integer id);
}
