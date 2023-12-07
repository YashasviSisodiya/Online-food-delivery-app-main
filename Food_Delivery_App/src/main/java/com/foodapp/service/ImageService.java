package com.foodapp.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;





public interface ImageService {
    String uploadImage(String path, MultipartFile file) throws IOException;

    
}
