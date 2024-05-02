package com.example.api1.api.controller;

import com.example.api1.api.model.User;
import com.example.api1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;
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
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existinguser = userService.get(id);
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

}
