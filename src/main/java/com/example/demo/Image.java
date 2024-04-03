package com.example.demo;

import java.sql.*;
class Image {
    private Blob blob;
    private int imageID;
    private String imageSize;
    private String addedBy;

    //Constructor methods
    public Image(){

    }

    public Image(Blob b, int id, String is, String ab){
        
    }

    //Mutator method
    public void setImageData(Blob blob){
        this.blob = blob;
    }

    public void setImageID(int imageID){
        this.imageID = imageID;
    }

    public void setImageSize(String imageSize){
        this.imageSize = imageSize;
    }

    public void setAddedBy(String addedBy){
        this.addedBy = addedBy;
    }

    //Accessor method
    public Blob getImageData(){
        return blob;
    }

    public int getImageID(){
        return imageID;
    }

    public String getImageSize(){
        return imageSize;
    }

    public String getAddedBy(){
        return addedBy;
    }

}