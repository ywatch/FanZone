package com.example.api1.api.controller;

import com.example.api1.api.model.Stade;
import com.example.api1.api.model.User;
import com.example.api1.service.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/stade")
public class StadeController {
    @Autowired
    private StadeService stadeService;
    @PostMapping("/add")
    public String addStade(@RequestBody Stade stade) {
        stadeService.saveStade(stade);
            return "Stade added";
    }
    @GetMapping("/getAll")
    public List<Stade> getAll() {
        return stadeService.getAllStades();
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        stadeService.delete(id);
        return "user is deleted"+id;
    }
    @GetMapping(path = "/{Name}")
    public ResponseEntity<Stade> get(@PathVariable String Name) {
        try{
            Stade stade = stadeService.getByName(Name);
            return new ResponseEntity<Stade>(stade, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Stade>(HttpStatus.NOT_FOUND);
        }
    }
}
