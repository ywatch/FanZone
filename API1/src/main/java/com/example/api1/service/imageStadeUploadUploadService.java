package com.example.api1.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class imageStadeUploadUploadService {

  public String uploadFile(MultipartFile file) throws Exception {
    // Define the directory where you want to save the file
    String uploadDir = "C:/Users/ywatch/Desktop/FanZone/src/assets/Stadepic/";

    // Create the directory if it doesn't exist
    Files.createDirectories(Paths.get(uploadDir));

    // Get the file name
    String fileName = file.getOriginalFilename();

    // Save the file to the specified directory
    Path filePath = Paths.get(uploadDir + fileName);
    Files.copy(file.getInputStream(), filePath);

    // Return the path where the file is saved
    return filePath.toString();
  }
}
