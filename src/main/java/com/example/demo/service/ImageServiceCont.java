package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;
import java.util.*;

@Service
public class ImageServiceCont implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image saveImage(Image image){
        return imageRepository.save(image);
    }

    @Override
    public List<Image> getImages(){
        return imageRepository.findAll();
    }
}