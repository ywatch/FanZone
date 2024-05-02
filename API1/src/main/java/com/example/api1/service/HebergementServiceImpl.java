package com.example.api1.service;

import com.example.api1.api.model.Hebergement;
import com.example.api1.api.model.Stade;
import com.example.api1.repository.HebergementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HebergementServiceImpl implements HebergementService {
    @Autowired
    HebergementRepository hebergementRepository;
    @Override
    public Hebergement savehebe(Hebergement h) {
        return hebergementRepository.save(h);
    }

    @Override
    public List<Hebergement> gethebe() {
        return hebergementRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        hebergementRepository.deleteById(id);
    }

    @Override
    public Hebergement getByName(String name) {
        List he = hebergementRepository.findAll();
        Hebergement hebe = null;
        for (Object u : he) {
            if (((Hebergement) u).getHname().equals(name)) {
                hebe = (Hebergement) u;
            }
        }
        return hebe;
    }
}
