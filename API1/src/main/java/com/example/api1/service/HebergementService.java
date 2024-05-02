package com.example.api1.service;

import com.example.api1.api.model.Hebergement;
import com.example.api1.api.model.Stade;

import java.util.List;

public interface HebergementService {
    public Hebergement savehebe(Hebergement h);
    public List<Hebergement> gethebe();
    public void delete(Integer id);
    public Hebergement getByName(String name);
}
