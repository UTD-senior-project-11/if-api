package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Administrator;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.*;

@Service
public class AdminServiceCont implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void saveAdmin(Administrator admin, int adminID){
        adminRepository.saveAdministrator(adminID, admin.getAdminUser(), admin.getAdminPass());
    }

    @Override
    public int getIndex(){
        return adminRepository.getLastRow() + 1;
    }

    @Override 
    public int checkDuplicate(Administrator admin){
        return adminRepository.noDuplicateUser(admin.getAdminUser());
    }

    @Override
    public int checkIfAdmin(Administrator admin){
        return adminRepository.sameUser(admin.getAdminUser(), admin.getAdminPass());
    }
}