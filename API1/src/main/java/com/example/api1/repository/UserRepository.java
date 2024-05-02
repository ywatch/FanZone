package com.example.api1.repository;
import com.example.api1.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Integer> {}
