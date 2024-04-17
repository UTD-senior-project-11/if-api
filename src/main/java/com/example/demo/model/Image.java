package com.example.demo.model;

import java.sql.*;
import java.util.*;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageID;
    @JsonProperty
    private String image;
    private String base64;
    private int imageSize;
    private boolean bannedStatus = true;

    //Constructors
    public Image(){}

    public Image(String imageData){
        this.base64 = imageData;
        //setImageData(imageData);
        //setImageSize(this.imageData);
    }

    public void getBase(){
        System.out.println(base64);
    }

    public Image(int imageID, String imageData, boolean bannedStatus) throws SQLException{
        this.imageID = imageID;
        setImageData(imageData);
        //setImageSize(this.image);
        this.bannedStatus = bannedStatus;
    }

    //Accessors
    public int getImageID(){return imageID;}

    public String getImageData(){return image;}

    public int getImageSize(){return imageSize;}

    public boolean getBannedStatus(){return bannedStatus;}

    //Mutators
    public void setImageID(int imageID){this.imageID = imageID;}

    public void setImageData(String imageData) throws SerialException, SQLException{
        //byte[] b = Base64.getDecoder().decode(imageData);
        //this.imageData = new SerialBlob(b);
    }

    //public void setImageData(Blob imageData){this.image = imageData;}

    public void setImageSize(Blob imageData) throws SQLException{
        byte b[] = imageData.getBytes(1, (int)imageData.length());
        this.imageSize = b.length;
    }

    public void setBannedStatus(boolean bannedStatus){this.bannedStatus = bannedStatus;}
}