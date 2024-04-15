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
        //System.out.println("\n\n\n" + admin.getAdminID() + " " + admin.getAdminUser() + " " + admin.getAdminPass() +"\n\n\n");
        int index = adminService.getIndex();
        int numEntries = adminService.checkDuplicate(admin);
        //System.out.println(numEntries);
        if (numEntries > 0){
            System.out.println("ERROR: PRE-EXISTING ACCOUNT");
            return "Error; pre-existing account detected. Please log in to continue.";
        } else {
            adminService.saveAdmin(admin, index);
            //System.out.println("\n\n"+admin.getAdminUser()+" "+index+" "+numEntries+"\n\n");
            return "Your administrator account has been created.";
        }
    }

    //@PostMapping("/login") //Finish

}