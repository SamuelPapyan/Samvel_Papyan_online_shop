package com.company.user;

public class User {
    private static int sequence;

    static {
        sequence = 0;
    }

    private final int id;
    private String firstName;
    private String lastName;
    private final String userName;
    private String password;

    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.id = ++sequence;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj instanceof User){
            User inputedUser = (User) obj;
            return inputedUser.userName.equals(this.userName);
        }
        return false;

    }

    public String toString() {
        return firstName + " " + lastName;
    }
}
