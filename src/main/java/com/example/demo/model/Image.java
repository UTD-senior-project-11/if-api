package com.example.demo.model;

import java.sql.*;
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
    private int imageSize;

    //Constructors
    public Image(){}

    public Image(int imageID, Blob imageData, int imageSize){
        this.imageID = imageID;
        this.imageData =imageData;
        this. imageSize = imageSize;
    }

    //Accessors
    public int getImageID(){return imageID;}

    public Blob getImageData(){return imageData;}

    public int imageSize(){return imageSize;}

    //Mutators
    public void setImageID(int imageID){this.imageID = imageID;}

    public void setImageData(Blob imageData){this.imageData = imageData;}

    public void setImageSize(int imageSize){this.imageSize = imageSize;}
}