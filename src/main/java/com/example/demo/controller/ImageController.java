package com.example.demo.controller;

import java.io.*;
import java.net.*;
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
    public String compareImages(@RequestBody Image image) throws SQLException, MalformedURLException{
        //Fill out image object
        image.setBase();
        image.setImageData(image.getBase());
        image.setImageSize(image.getImageData());
        image.setImageID(imageService.getIndex());

        //Store image (temporarily if not banned)
        imageService.saveImage(image);
        
        //Connect to AI API
        StringBuffer response = new StringBuffer();
        try {
            URL url = new URL("http://localhost:5000/sendimages");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            conn.setDoOutput(true);
		    OutputStream os = conn.getOutputStream();
		    os.write(image.getBase().getBytes());
		    os.flush();
		    os.close();

            int responseCode = conn.getResponseCode();
            
            String inputLine;
            if (responseCode == HttpURLConnection.HTTP_OK){
                System.out.println("AI: CONNECTION ESTABLISHED");
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                
                while ((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.out.println("ERROR: FAILED TO CONNECT");
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

        //System.out.println(response); //Test

        //Verify if the image should be added based on returned status
        //Dogs are banned, cats are not        
        if (response.toString().equals("C")){
            imageService.deleteLast();
        } else if (response.toString().equals("D")){
            //Check if added image was actually a duplicate; delete if true
            int numEntries = imageService.checkDuplicate(image);
            if (numEntries > 1){
                System.out.println("ERROR: DUPLICATE IMAGE");
                imageService.deleteLast();
            } else {
                System.out.println("Valid entry.");
            }
        }
        
        return response.toString();
    }

    //Forward result of comparison to UI
    /*
    @GetMapping("/compareresult")
    public boolean compareResult(){
        Image tempImage = imageService.getLast();
        imageService.deleteLast();

        

        return tempImage.getBannedStatus();
    }
    */
}