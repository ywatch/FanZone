package com.example.api1.repository;

import com.example.api1.api.model.Hebergement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HebergementRepository extends JpaRepository<Hebergement, Integer> {
}
