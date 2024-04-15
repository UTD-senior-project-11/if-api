package com.example.demo.service;

import com.example.demo.model.Administrator;

//Needs more
public interface AdminService {
    public void saveAdmin(Administrator admin, int adminID);

    public int getIndex();

    public int checkDuplicate(Administrator admin);
}