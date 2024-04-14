package com.example.demo.service;

import com.example.demo.model.Image;
import java.util.*;

//Needs more (to link with AI)
public interface ImageService {
    public Image saveImage(Image image); //Saves image to database

    public List<Image> getImages();
}