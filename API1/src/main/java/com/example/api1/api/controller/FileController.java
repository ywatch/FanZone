package com.example.api1.api.controller;
import com.example.api1.service.imageStadeUploadUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

  private final imageStadeUploadUploadService imageStadeUploadUploadService;

  @Autowired
  public FileController(imageStadeUploadUploadService imageStadeUploadUploadService) {
    this.imageStadeUploadUploadService = imageStadeUploadUploadService;
  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file) {
    if (file.isEmpty()) {
      return "Please select a file to upload";
    }
    try {
      String filePath = imageStadeUploadUploadService.uploadFile(file);
      return "File uploaded successfully. Path: " + filePath;
    } catch (Exception e) {
      return "Failed to upload file: " + e.getMessage();
    }
  }
}
