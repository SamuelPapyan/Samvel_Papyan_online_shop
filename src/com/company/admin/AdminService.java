package com.company.admin;

import com.company.user.User;
import com.company.user.UserServiceAbstract;

import java.util.Scanner;

public class AdminService extends UserServiceAbstract{
    private static Admin[] adminList= new Admin[1];

    private Scanner scanner;

    public AdminService() {
        this.scanner =  new Scanner(System.in);;
    }

    static {
        adminList[0] = new Admin("Samvel", "Papyan", "AdminSam", "123456");
    }
    public User registration(){

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Username: ");
        String userName = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        return registration(firstName,lastName,userName,password);
    }

    public User registration(String firstName, String lastName, String userName, String password){
        Admin admin = new Admin(firstName,lastName, userName, password);

        Admin[] updated = new Admin[adminList.length+1];

        for (int i = 0; i <adminList.length; i++) {
            updated[i] = adminList[i];
        }
        updated[updated.length-1] = admin;
        adminList = updated;
        return admin;
    }

    public User login(String userName, String password){
        for(Admin admin : adminList) {
            if(admin.getPassword().equals(password) && admin.getUserName().equals(userName)){
                System.out.println("Welcome Admin " + admin.getUserName());
                return admin;
            }
        }
        System.out.println("Invalid username or password");
        return null;
    }

    public User login(){
        System.out.print("Username: ");
        String userName = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        return login(userName, password);
    }
}
