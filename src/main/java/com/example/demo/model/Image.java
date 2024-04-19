package com.example.demo.model;

import java.sql.*;
import java.util.*;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mysql.cj.util.Base64Decoder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageID;
    private Blob imageData;
    @JsonProperty
    private String base64;
    private String image64;
    private int imageSize;
    private boolean bannedStatus = true;
    

    //Constructors
    public Image(){}

    public Image(String base64) throws SerialException, SQLException{
        //System.out.println(base64);
    }

    public String getBase(){
        //System.out.println(image64.substring(0, 20));
        //String test = base64.substring(0,200);
        //System.out.println(test);
        //test = base64;
        //System.out.println(test);
        return image64;
    }

    public void setBase(){
        image64 = base64;
    }

    //Accessors
    public int getImageID(){return imageID;}

    public Blob getImageData(){return imageData;}

    public String getImageDataString(){return imageData.toString();}

    public int getImageSize(){return imageSize;}

    public boolean getBannedStatus(){return bannedStatus;}

    //Mutators
    public void setImageID(int imageID){this.imageID = imageID;}

    public void setImageData(String data) throws SerialException, SQLException{
        byte[] imageByte = Base64.getDecoder().decode(data);
        this.imageData = new SerialBlob(imageByte);
    }

    public void setImageSize(Blob imageData) throws SQLException{
        byte b[] = imageData.getBytes(1, (int)imageData.length());
        this.imageSize = b.length;
    }

    public void setBannedStatus(boolean bannedStatus){this.bannedStatus = bannedStatus;}
}