package com.example.api1.api.controller;


import com.example.api1.api.model.Hebergement;
import com.example.api1.service.HebergementService;
import com.example.api1.service.imageHebergementUploadService;
import com.example.api1.service.imageStadeUploadUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/hebergement")
@CrossOrigin(origins = "http://localhost:4200")
public class HebergementController {
  private imageHebergementUploadService imageHebergementUploadService;

  @Autowired
    HebergementService hebergementService;
  public HebergementController(imageHebergementUploadService imageHebergementUploadService) {
    this.imageHebergementUploadService = imageHebergementUploadService;
  }
    @PostMapping("/add")
    public String addStade(@RequestPart("hebergement") Hebergement hebergement, @RequestPart("file") MultipartFile file) {
      try {
        hebergementService.savehebe(hebergement);
        String filePath = imageHebergementUploadService.uploadFile(file);
        hebergement.setPathpic(filePath);
        hebergementService.savehebe(hebergement);
        return "Stade added; File uploaded successfully. Path: " + filePath;
      } catch (Exception e) {
        return "Failed to upload file: " + e.getMessage();
      }
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
