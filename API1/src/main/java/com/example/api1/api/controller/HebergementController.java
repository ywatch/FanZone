package com.example.api1.api.controller;


import com.example.api1.api.model.Hebergement;
import com.example.api1.repository.HebergementRepository;
import com.example.api1.service.HebergementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/hebergement")
public class HebergementController {
    @Autowired
    HebergementService hebergementService;
    @PostMapping("/add")
    public String addStade(@RequestBody Hebergement hebergement) {
        hebergementService.savehebe(hebergement);
        return "Stade added";
    }
    @GetMapping("/getAll")
    public List<Hebergement> getAll() {
        return hebergementService.gethebe();
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        hebergementService.delete(id);
        return "user is deleted"+id;
    }
    @GetMapping(path = "/{Name}")
    public ResponseEntity<Hebergement> get(@PathVariable String Name) {
        try{
            Hebergement hebe = hebergementService.getByName(Name);
            return new ResponseEntity<Hebergement>(hebe, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Hebergement>(HttpStatus.NOT_FOUND);
        }
    }
}
