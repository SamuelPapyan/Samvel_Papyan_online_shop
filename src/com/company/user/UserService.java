package com.company.user;

import java.util.Scanner;

public class UserService extends UserServiceAbstract{
    private static User[] userList= new User[1];

    private Scanner scanner;

    public UserService() {
        this.scanner =  new Scanner(System.in);;
    }

    static {
        userList[0] = new User("Samvel", "Papyan", "SamPap", "123456");
    }

    public User registration(){

        System.out.println("First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Username: ");
        String userName = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        return registration(firstName,lastName,userName,password);
    }

    public User registration(String firstName, String lastName, String userName, String password){
        User user = new User(firstName,lastName, userName, password);

        User[]  updated = new User[userList.length+1];

        for (int i = 0; i < userList.length; i++) {
            updated[i] = userList[i];
        }
        updated[updated.length-1] = user;
        userList = updated;
        return user;
    }

    public User login(String userName, String password){
        for (User user : userList) {
            if(user.getPassword().equals(password) && user.getUserName().equals(userName)){
                System.out.println("Welcome " + user.getUserName());
                return user;
            }
        }
        System.out.println("Invalid username or password");
        return null;
    }

    public User login(){
        System.out.println("Username: ");
        String userName = scanner.nextLine();
        System.out.println("Password ");
        String password = scanner.nextLine();
        return login(userName, password);
    }


}
