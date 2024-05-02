package com.example.api1.service;

import com.example.api1.api.model.Stade;
import java.util.List;

public interface StadeService {
    public Stade saveStade(Stade s);
    public List<Stade> getAllStades();
    public void delete(Integer id);
    public Stade getByName(String name);

}
