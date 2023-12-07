package com.foodapp.controller;

import com.foodapp.service.ImageService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;



@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {
    @Autowired

    private ImageService imageService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadImage(@RequestParam("image") MultipartFile image) throws IOException {
        String fileName=null;
        try{
            fileName= this.imageService.uploadImage(path, image);
        } catch (IOException e)
        {e.printStackTrace();
            return new ResponseEntity<>(new FileResponse(null, "Image not successfully inserted"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new FileResponse(fileName, "Image successfully inserted"),HttpStatus.OK);
    }
}


