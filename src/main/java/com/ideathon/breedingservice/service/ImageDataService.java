package com.ideathon.breedingservice.service;

import com.ideathon.breedingservice.model.ImageData;
import com.ideathon.breedingservice.repo.ImageDataRepository;
import com.ideathon.breedingservice.util.IdConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Component
@Slf4j
public class ImageDataService {

    private String storageLocation = "C:\\Users\\manoj.kumar8\\Documents\\BreedingServiceData\\";
    private ImageDataRepository imageDataRepository;

    @Autowired
    public void setImageDataRepository(ImageDataRepository imageDataRepository) {
        this.imageDataRepository = imageDataRepository;
    }

    public boolean saveImageToFileStorage(MultipartFile multipartFile) throws IOException {

        String filePath = storageLocation + multipartFile.getOriginalFilename();
        ImageData imageData = imageDataRepository.save(ImageData.builder()
                        .id(IdConverter.toStandardBinaryUUID(UUID.randomUUID()))
                        .name(multipartFile.getOriginalFilename())
                        .imageType(multipartFile.getContentType())
                        .entityCode("TEST")
                        .entityId(null)
                        .imagePath(filePath).build());

        multipartFile.transferTo(new File(filePath));

        if(imageData != null)
            return true;
        else
            return false;

    }

    public byte[] getImageFromFilePath(String fileName) throws IOException {
        ImageData imageData = imageDataRepository.getImageByName(fileName);
        String imagePath = imageData.getImagePath();

        byte[] image = Files.readAllBytes(new File(imagePath).toPath());
        return image;
    }
}
