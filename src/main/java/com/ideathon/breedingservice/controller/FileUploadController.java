package com.ideathon.breedingservice.controller;

import com.ideathon.breedingservice.model.UploadFileResponse;
import com.ideathon.breedingservice.service.FileStorageService;
import com.ideathon.breedingservice.service.ImageDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
public class FileUploadController {

    private FileStorageService fileStorageService;

    private ImageDataService imageDataService;

//    @Autowired
    public FileUploadController(FileStorageService fileStorageService, ImageDataService imageDataService) {
        this.fileStorageService = fileStorageService;
        this.imageDataService= imageDataService;
    }


    @PostMapping("/uploadFile/{patientId}")
    public UploadFileResponse uploadFile(@PathVariable final String patientId,@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/downloadFile/")
                .path(patientId+"/")
                .path(fileName)
                .toUriString();

        //saving to DB
        imageDataService.saveImageToDB(file, fileDownloadUri, patientId);

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles/{patientId}")
    public List<UploadFileResponse> uploadMultipleFiles(@PathVariable final String patientId,@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(patientId,file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{patientId}/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable final String patientId,@PathVariable String fileName, HttpServletRequest request) {

        Resource resource = fileStorageService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            //log.info("Could not determine file type.");
        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
