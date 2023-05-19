package com.ideathon.breedingservice.controller;

import com.ideathon.breedingservice.service.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/image")
public class ImageDataController {

    private ImageDataService imageDataService;

    @Autowired
    public void setImageDataService(ImageDataService imageDataService) {
        this.imageDataService = imageDataService;
    }

    @PostMapping("/saveImage")
    public ResponseEntity<?> saveImageToStorage(@RequestParam("image")MultipartFile multipartFile) throws IOException {
        boolean isImageSaved = imageDataService.saveImageToFileStorage(multipartFile);

        return ResponseEntity.status(HttpStatus.OK)
                .body(isImageSaved);
    }

    @GetMapping("/getImage/{fileName}")
    public ResponseEntity<?> getImageFromStorage(@PathVariable String fileName) throws IOException {
        byte[] image = imageDataService.getImageFromFilePath(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);

    }
}
