package com.example.demo.model;

import java.sql.*;
import java.util.*;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.fasterxml.jackson.annotation.JsonProperty;
//import com.mysql.cj.util.Base64Decoder;

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
    private String base64; //Encoded base64 String
    private String image64; //Local copy of base64 String (used to manipulate object values)
    private int imageSizeKB;
    private boolean bannedStatus = true;
    

    //Constructors
    public Image(){}

    public Image(String base64) throws SerialException, SQLException{
        this.base64 = base64;
        //System.out.println(base64);
    }

    public Image(int imageID, String encoded, int imageSize, boolean bannedStatus) throws SerialException, SQLException{
        this.imageID = imageID;
        image64 = encoded;
        setImageData(encoded);
        imageSizeKB = imageSize;
        this.bannedStatus = bannedStatus;
    }

    //Accessors
    public String getBase(){return image64;}

    public int getImageID(){return imageID;}

    public Blob getImageData(){return imageData;}

    public int getImageSize(){return imageSizeKB;}

    public boolean getBannedStatus(){return bannedStatus;}

    //Mutators
    public void setBase(){image64 = base64;}

    public void setImageID(int imageID){this.imageID = imageID;}

    public void setImageData(String data) throws SerialException, SQLException{
        byte[] imageByte = Base64.getDecoder().decode(data);
        this.imageData = new SerialBlob(imageByte);
        //System.out.println(imageData.length());
    }

    public void setImageSize(Blob imageData) throws SQLException{
        byte b[] = imageData.getBytes(1, (int)imageData.length());
        this.imageSizeKB = b.length / 1000;
    }

    public void setBannedStatus(boolean bannedStatus){this.bannedStatus = bannedStatus;}
}