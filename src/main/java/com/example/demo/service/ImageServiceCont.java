package com.example.demo.service;

import java.util.*;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;

@Service
public class ImageServiceCont implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void saveImage(Image image){
        imageRepository.saveImage(image.getImageID(), image.getImageData(), image.getImageSize(), image.getBannedStatus());
    }

    @Override
    public int getIndex(){
        return imageRepository.getLastRow() + 1;
    }

    @Override
    public int checkDuplicate(Image image){
        return imageRepository.noDuplicate(image.getImageData());
    }

    @Override
    public List<Blob> getAllImages(){
        return imageRepository.getAllImages();
    }
}