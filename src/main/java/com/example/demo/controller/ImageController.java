package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Image;
import com.example.demo.service.ImageService;
import com.example.demo.service.ImageServiceCont;
import java.util.*;

@RestController
@RequestMapping("image")
@CrossOrigin
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/add")
    public String add(@RequestBody Image image){
        imageService.saveImage(image);
        return "New image has been added.";
    }

    @GetMapping("/getimages")
    public List<Image> list(){
        return imageService.getImages();
    }
}