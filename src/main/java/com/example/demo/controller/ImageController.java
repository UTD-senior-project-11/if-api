package com.example.demo.controller;

import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Image;
import com.example.demo.service.ImageService;
import com.example.demo.service.ImageServiceCont;

@RestController
@RequestMapping("image")
@CrossOrigin
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/add")
    public String add(@RequestBody Image image) throws SerialException, SQLException{
        //Fill out image object
        image.setBase();
        image.setImageData(image.getBase());
        image.setImageSize(image.getImageData());
        image.setImageID(imageService.getIndex());

        //Add to DB
        int numEntries = imageService.checkDuplicate(image);
        if (numEntries > 0){
            System.out.println("ERROR; IMAGE PRESENT WITHIN TABLE");
            return "Error; image already exists within table.";
        } else {
            imageService.saveImage(image);
            return "New image has been added.";
        }
    }

    @GetMapping("/getAll")
    public String getAll(){
        imageService.getAllImages();
        return "Images provided.";
    }

}