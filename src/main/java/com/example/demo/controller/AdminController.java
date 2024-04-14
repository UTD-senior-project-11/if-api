package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.AdminService;
import com.example.demo.service.AdminServiceCont;
import com.example.demo.model.Administrator;

@RestController
@RequestMapping("administrator")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public String signup(@RequestBody Administrator admin){
        adminService.saveAdmin(admin);
        return "Your administrator account has been created";
    }

    @GetMapping("/login")
    public boolean login(@RequestBody Administrator admin){
        if(adminService.checkAdmin(admin) == false){
            return false; 
            //"Error; no account found. Please sign up"; 
        } else {
            return true;
            //"Login successful";
        }
    }
}