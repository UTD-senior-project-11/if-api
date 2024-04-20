package com.example.demo.model;

//import java.util.Random;

//import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminID;
    private String adminUser;
    private String adminPass;

    //Constructors
    public Administrator(){
    }

    public Administrator(String adminUser, String adminPass){
        //this.adminID = Integer.parseInt(generateAdminID());
        this.adminUser = adminUser;
        this.adminPass = adminPass;
    }

    //Accessors
    public int getAdminID(){
        return adminID; 
    }

    public String getAdminUser(){
        return adminUser;
    }

    public String getAdminPass(){
        return adminPass;
    }

    //Mutators
    public void setAdminID(int adminID){
        this.adminID = adminID;
    }

    public void setAdminUser(String adminUser){
        this.adminUser = adminUser;
    }

    public void setAdminPass(String adminPass){
        this.adminPass = adminPass;
    }

    //Generate random Administrator ID for use as a primary key
    /*public static String generateAdminID(){
        StringBuilder temp = new StringBuilder();
        String idCharSet = "0123456789";
        Random rand = new Random();
        int randIndex;

        for(int i = 0; i < 9; i++){
            randIndex = rand.nextInt(10);
            temp.append(idCharSet.charAt(randIndex));
        }

        String id = temp.toString();

        return id;
    }*/
}