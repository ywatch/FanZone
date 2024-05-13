package com.example.api1.api.controller;

import com.example.api1.api.model.Stade;
import com.example.api1.service.imageStadeUploadUploadService;
import com.example.api1.service.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/stade")
public class StadeController {
  private imageStadeUploadUploadService imageStadeUploadUploadService;
  @Autowired
  private StadeService stadeService;
  public StadeController(imageStadeUploadUploadService imageStadeUploadUploadService) {
    this.imageStadeUploadUploadService = imageStadeUploadUploadService;
  }

  @PostMapping("/add")
  public String addStade(@RequestPart("stade") Stade stade, @RequestPart("file") MultipartFile file) {
    try {
      stadeService.saveStade(stade);
      String filePath = imageStadeUploadUploadService.uploadFile(file);
      stade.setPathpic(filePath);
      stadeService.saveStade(stade);
      return "Stade added; File uploaded successfully. Path: " + filePath;
    } catch (Exception e) {
      return "Failed to upload file: " + e.getMessage();
    }
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
