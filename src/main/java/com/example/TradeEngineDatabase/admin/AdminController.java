package com.example.TradeEngineDatabase.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;

    }

    @PostMapping("/login")
    public ResponseEntity<Admin> loginClient(@RequestBody Admin admin) throws IllegalStateException {
        admin = adminService.loginAdmin(admin);
        return  new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/register")
    public void registerAdmin(@RequestBody Admin admin) throws IllegalStateException {
        adminService.addAdmin(admin);
    }

}
