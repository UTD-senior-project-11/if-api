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
        image.setBase();
        image.setImageData(image.getBase());
        //System.out.println(image.getImageDataString());
        //System.out.println("\n"+image.getImageData()+"\n");
        //imageService.saveImage(image);
        return "New image has been added.";
    }

}