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
    public void saveAdmin(Administrator admin){
        adminRepository.saveAdministrator(admin.getAdminUser(), admin.getAdminPass());
    }
}