package com.example.demo.controller;

import java.sql.SQLException;
import java.util.*;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Image;
import com.example.demo.service.ImageService;
//import com.example.demo.service.ImageServiceCont;

@RestController
@RequestMapping("image")
@CrossOrigin
public class ImageController {
    @Autowired
    private ImageService imageService;

    //Add image to DB
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

    //Get images from DB for display grid
    @GetMapping("/getAll")
    public List<String> getAll(){
        return imageService.getAllImages();
    }

    //Send image to AI for comparison
    @PostMapping("/compare")
    public String compareImages(@RequestBody Image image) throws SQLException{
        //Fill out image object
        image.setBase();
        image.setImageData(image.getBase());
        image.setImageSize(image.getImageData());
        image.setImageID(imageService.getIndex());

        //Store image (temporarily)
        imageService.saveImage(image);


        
        return "Test";
    }

    //Forward result of comparison to UI
    @GetMapping("/compareresult")
    public boolean compareResult(){
        Image tempImage = imageService.getLast();
        imageService.deleteLast();

        

        return tempImage.getBannedStatus();
    }
}