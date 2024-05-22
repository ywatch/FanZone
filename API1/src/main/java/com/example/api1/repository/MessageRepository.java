package com.example.api1.repository;

import com.example.api1.api.model.MessageForum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageForum, Integer> {
}
