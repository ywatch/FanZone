package com.example.api1.service;

import com.example.api1.api.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User get(Integer id);
    public void delete(Integer id);
    public User getByName(String name);
    public boolean isvalideuser(String username,String password);
}
