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
    private boolean loginStatus;

    public void updateLoginStatus(boolean stat){
        this.loginStatus = stat;
    }
    public boolean getLoginStatus(){
        return loginStatus;
    }

    //Signup
    @PostMapping("/signup")
    public String signup(@RequestBody Administrator admin){
        int index = adminService.getIndex(); //Get latest available index (linear)
        int numEntries = adminService.checkDuplicate(admin); //Check if there are multiple entries in DB
        //Determine if account already exists
        if (numEntries > 0){
            System.out.println("ERROR: PRE-EXISTING ACCOUNT");
            return "Error; pre-existing account detected. Please log in to continue.";
        } else {
            adminService.saveAdmin(admin, index); //Save account to Administrator table
            return "Your administrator account has been created.";
        }
    }

    //Verify if login credentials exist
    @PostMapping("/login") 
    public String login(@RequestBody Administrator admin){
        if (adminService.checkIfAdmin(admin) == 1){
            updateLoginStatus(true);
            System.out.println("\n"+getLoginStatus()+"\n");
            return "Account found";
        } else {
            updateLoginStatus(false);
            System.out.println("\n"+getLoginStatus()+"\n");
            return "Account not found";
        }
    }

    //Update login status
    @GetMapping("/getlogin")
    public boolean loginStat(){
        return getLoginStatus();
    }

}