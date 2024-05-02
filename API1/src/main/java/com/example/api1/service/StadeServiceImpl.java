package com.example.api1.service;

import com.example.api1.api.model.Stade;
import com.example.api1.api.model.User;
import com.example.api1.repository.StadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadeServiceImpl implements StadeService {
    @Autowired
    private StadeRepository stadeRepository;

    @Override
    public Stade saveStade(Stade s) {

        return stadeRepository.save(s);
    }

    @Override
    public List<Stade> getAllStades() {

        return stadeRepository.findAll();
    }

    @Override
    public void delete(Integer id) {

        stadeRepository.deleteById(id);
    }

    @Override
    public Stade getByName(String name) {
        List st = stadeRepository.findAll();
        Stade stade = null;
        for (Object u : st) {
            if (((Stade) u).getStadename().equals(name)) {
                stade = (Stade) u;
            }
        }
        return stade;
    }
}
