package com.company;
import java.io.*;
import java.util.Scanner;
import com.company.user.*;
import com.company.admin.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UserServiceAbstract userService;
    static String request;
    static Auth user;

    static void instructionCase1(){
        System.out.println("Enter admin for admin panel\n(if you don't have admin account enter 1 for registration)");
        System.out.println("Enter user for shopping\n(if you don't have user account enter 2 for registration)");
        System.out.println("Enter exit for exit this program");
        request = scanner.nextLine();
        requestCase1();
    }

    static void instructionCaseAdmin(){
        System.out.println(user);
        System.out.println("Enter 1 for adding product");
        System.out.println("Enter 0 for logout");
        request = scanner.nextLine();
        requestAdmin();
    }

    static void instructionCaseUser(){
        System.out.println(user);
        System.out.println("Enter 1 for make shopping");
        System.out.println("Enter 0 for logout");
        request = scanner.nextLine();
        requestUser();
    }

    static void requestCase1(){
        if(request.equals("admin")){
            userService = new AdminService();
            login();
        }
        else if (request.equals("user")){
            userService = new UserService();
            login();
        }
        else if (request.equals("1")){
            userService = new AdminService();
            registration();
        }
        else if (request.equals("2")){
            userService = new UserService();
            registration();
        }
        else if (request.equals("exit")){
            System.out.println("Good Bye");
            System.exit(0);
        }
        else{
            instructionCase1();
        }
    }
    static void requestAdmin(){
        if(request.equals("1")){
            user.addProduct();
            instructionCaseAdmin();
        }
        else if (request.equals("0")){
            user = null;
            instructionCase1();
        }
        else{
            instructionCaseAdmin();
        }
    }

    static void requestUser(){
        if(request.equals("1")){
            user.makeShopping();
            instructionCaseUser();
        }
        else{
            user = null;
            instructionCase1();
        }
    }

    static void registration(){
        if(request.equals("1"))
            request = "admin";
        else
            request = "user";
        userService.registration();
        login();
    }
    static void login(){
        if(request.equals("admin")) {
            System.out.println("Admin login");
            user = (Admin) userService.login();
        }
        else {
            System.out.println("User Login");
            user = (User) userService.login();
        }
        if(user != null)
            if(request.equals("admin"))
                instructionCaseAdmin();
            else
                instructionCaseUser();
        else
            instructionCase1();
    }

    public static void main(String[] args){
        System.out.println("Samvel Papyan Online Shop");
        instructionCase1();
    }
}
