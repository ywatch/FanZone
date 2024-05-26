package com.example.api1.api.controller;

import com.example.api1.api.model.CommentaireForum;
import com.example.api1.api.model.CommentaireHebergement;
import com.example.api1.api.model.CommentaireStade;
import com.example.api1.api.model.User;
import com.example.api1.repository.CommentaireHebergementRepository;
import com.example.api1.repository.CommentaireStadeRepository;
import com.example.api1.repository.CommentairemessageforumRepository;
import com.example.api1.service.UserService;
import com.example.api1.util.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentairemessageforumRepository commentairemessageforumRepository;
    @Autowired
    private CommentaireStadeRepository commentaireStadeRepository;
    @Autowired
    private CommentaireHebergementRepository commentaireHebergementRepository;
    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "new user is added";
    }
    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

           if (userService.isvalideuser(username,password)) {
               return "login successful";
           }
           else {
               return"login failed";
           }

    }
    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAllUsers();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try{
            User user = userService.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping(path = "/{Name}")
    public ResponseEntity<User> get(@PathVariable String Name) {
        try{
            User user = userService.getByName(Name);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
  @GetMapping(path = "Connect/{Name}")
  public ResponseEntity<User> connect(@PathVariable String Name) {
    try{
      User user = userService.getByName(Name);
      user.setConnect(true);
      userService.saveUser(user);
      return new ResponseEntity<User>(user, HttpStatus.OK);
    }catch(NoSuchElementException e){
      return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping(path = "Disconnect/{Name}")
  public ResponseEntity<User> Disconnect(@PathVariable String Name) {
    try{
      User user = userService.getByName(Name);
      System.out.println(user.getId());
      user.setConnect(false);
      userService.saveUser(user);
      return new ResponseEntity<User>(user, HttpStatus.OK);
    }catch(NoSuchElementException e){
      return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }
  }
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user,@PathVariable String id) {
        try {
            User existinguser = userService.getByName(id);
            existinguser.setName(user.getName());
            existinguser.setEmail(user.getEmail());
            existinguser.setPassword(user.getPassword());
            userService.saveUser(existinguser);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch(NoSuchElementException e){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "user is deleted"+id;
    }
    @GetMapping("/commentforum/{name}")
    public List<comment> getcommentbycontenu(@PathVariable String name) {
      List<CommentaireForum> c = commentairemessageforumRepository.findAll();
      List <comment>ret = new ArrayList<comment>();
      for (CommentaireForum c1 : c) {
        if (Objects.equals(c1.getUser().getName(), name)){
          ret.add(new comment(c1.getUser().getName(),c1.getContenu()));
        }
      }
  return ret; }
  @GetMapping("/commentstade/{name}")
  public List<comment> getByName(@PathVariable String name) {
    List<CommentaireStade> c = commentaireStadeRepository.findAll();
    List<comment> c1 = new ArrayList<comment>();
    for (CommentaireStade c2 : c) {
      if(c2.getUser().getName().equals(name)){
        c1.add(new comment(c2.getUser().getName(), c2.getContenu()));
      }else {
        return null;
      }
    }
    return c1;
  }
  @GetMapping("/commenthebe/{name}")
  public List<comment> getByNamehebe(@PathVariable String name) {
    List<CommentaireHebergement> c = commentaireHebergementRepository.findAll();
    List <comment>ret = new ArrayList<comment>();
    for (CommentaireHebergement c1 : c) {
      if (Objects.equals(c1.getUser().getName(), name)) {
        ret.add(new comment(c1.getUser().getName(), c1.getContenu()));
      } else {
        System.out.println("Not found");
        return null;
      }
    }
    return ret;
  }
}


