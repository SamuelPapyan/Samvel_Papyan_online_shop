package com.company.user;

import java.util.Scanner;

public class UserService extends UserServiceAbstract{
    private static User[] userList= new User[1];

    private Scanner scanner;

    public UserService() {
        this.scanner =  new Scanner(System.in);;
    }

    static {
        userList[0] = new User("Jhon", "Smith", "jh@gmail.com", "jhon123");
    }

    public User registration(){

        System.out.println("please enter first name");
        String firstName = scanner.nextLine();
        System.out.println("please enter lasr name");
        String lastName = scanner.nextLine();
        System.out.println("please enter userName ");
        String userName = scanner.nextLine();
        System.out.println("please enter paswword ");
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
                System.out.println(user.toString() + " successfully loge in");
                return user;
            }
        }
        System.out.println("error wrong username or password");
        return null;
    }

    public User login(){
        System.out.println("please enter userName ");
        String userName = scanner.nextLine();
        System.out.println("please enter paswword ");
        String password = scanner.nextLine();
        return login(userName, password);
    }


}
