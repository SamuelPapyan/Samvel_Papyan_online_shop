package com.company.user;

public abstract class UserServiceAbstract implements UserServiceInterface {

    private int count;

    public UserServiceAbstract(){

    }
    public abstract User registration(String firstName, String lastName, String userName, String password);
    public abstract User login(String userName, String password);

    public int getCount() {
        return count;
    }

    public void voidIncrease(){
        count++;
    }
}
