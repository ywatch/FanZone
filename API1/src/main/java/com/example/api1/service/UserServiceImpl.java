package com.example.api1.service;

import com.example.api1.api.model.User;
import com.example.api1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void  delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByName(String name) {
        List<User> us = userRepository.findAll();
        User user = null;
        for (Object u : us) {
            if (((User) u).getName().equals(name)) {
                 user = (User) u;
            }
        }
        return user;
    }

    @Override
    public boolean isvalideuser(String username,String password) {
        User user = getByName(username);
        if (user.getName().equals(username)&&user.getPassword().equals(user.getPassword())){
            return true;
        }
        else {
            return false;
        }
    }
}
