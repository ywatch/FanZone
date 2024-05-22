package com.example.api1.service;

import com.example.api1.api.model.MessageForum;
import com.example.api1.repository.MessageRepository;
import com.example.api1.util.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
  @Autowired
  MessageRepository messageRepository;
  @Override
  public MessageForum savemessage(MessageForum m) {
    return messageRepository.save(m);
  }

  @Override
  public List<Posts> getAllmessage() {
    List<MessageForum> messages = messageRepository.findAll();
    List<Posts> posts = new ArrayList<>();
    for (MessageForum m : messages) {
      posts.add(
        new Posts(m.getIdm(),m.getUser().getName(),m.getDatepublication(),m.getContenu(),m.getPathpic())
      );
    }
    return posts;
  }

  @Override
  public MessageForum getmessagebyid(int id) {
    List<MessageForum>m= messageRepository.findAll();
    for (MessageForum ma :m){
      if(ma.getIdm()==id){
        return ma;
      }
    }
    return null;
  }

  @Override
  public void delete(Integer id) {
  messageRepository.deleteById(id);
  }
}
