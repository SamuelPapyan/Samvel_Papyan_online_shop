package com.company;
import com.company.user.*;
import com.company.admin.*;

public class Main {

    public static void main(String[] args) {
        /*
        UserService userService = new UserService();

        userService.registration();
        userService.login();
         */

        AdminService adminService = new AdminService();
        adminService.registration();
        Admin admin = (Admin)adminService.login();
        if(admin != null){
            admin.addProduct();
        }
    }
}
