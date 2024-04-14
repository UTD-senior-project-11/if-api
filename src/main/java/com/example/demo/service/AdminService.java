package com.example.demo.service;

import com.example.demo.model.Administrator;

//Needs more
public interface AdminService {
    public Administrator saveAdmin(Administrator admin); //Save admin info into database

    public boolean checkAdmin(Administrator admin); //Check if admin info is present in database
}