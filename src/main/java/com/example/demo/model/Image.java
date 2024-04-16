package com.example.demo.model;

import java.sql.*;
import java.util.*;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

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
        setImageSize(this.imageData);
        this.bannedStatus = bannedStatus;
    }

    //Accessors
    public int getImageID(){return imageID;}

    public Blob getImageData(){return imageData;}

    public int getImageSize(){return imageSize;}

    public boolean getBannedStatus(){return bannedStatus;}

    //Mutators
    public void setImageID(int imageID){this.imageID = imageID;}

    public void setImageData(String imageData) throws SerialException, SQLException{
        //byte[] b = Base64.getDecoder().decode(imageData);
        //this.imageData = new SerialBlob(b);
    }

    public void setImageData(Blob imageData){this.imageData = imageData;}

    public void setImageSize(Blob imageData) throws SQLException{
        byte b[] = imageData.getBytes(1, (int)imageData.length());
        this.imageSize = b.length;
    }

    public void setBannedStatus(boolean bannedStatus){this.bannedStatus = bannedStatus;}
}