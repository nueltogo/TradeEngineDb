package com.example.TradeEngineDatabase.admin;

import com.sun.istack.NotNull;
import org.hibernate.hql.internal.ast.tree.IndexNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;


    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> findAdmins(){
        return adminRepository.findAll();
    }

    //add a new admin
    public void addAdmin(@NotNull Admin admin){
        Admin newadmin = adminRepository.save(admin);
    }

    //login
    public Admin loginAdmin(@NotNull Admin admin) {
        return adminRepository.findAdminByEmailAndPassword(admin.getEmail(), admin.getPassword()).orElseThrow(
                ()-> new IllegalStateException("Admin does not exist or wrong input of admin")
        );
    }

}
