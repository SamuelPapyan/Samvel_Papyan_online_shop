package com.company.user;

import java.util.Scanner;
import com.company.product.*;

public class User implements Auth{
    private static int sequence;
    protected Scanner scanner;
    protected ProductService productService;

    static {
        sequence = 0;
    }

    private final int id;
    private String firstName;
    private String lastName;
    private final String userName;
    private String password;
    private int money;

    public User(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.money = 100000;
        this.id = ++sequence;
        productService = new ProductService();
        scanner = new Scanner(System.in);
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

    public void makeShopping(){
        System.out.println(this);
        for(Product item : productService.getProducts()){
            System.out.println(item);
        }
        System.out.println("Enter number of product to buy");
        int productId = scanner.nextInt();
        Product product = productService.findProductById(productId);
        if(product != null){
            money -= product.getPrice();
        }
        else{
            System.out.println("Product is not found. Try again.");
            makeShopping();
        }
    }

    public String toString() {
        String txt = firstName + " " + lastName + " | ";
        txt += userName + " | ";
        txt += "Money: " + money;
        return txt;
    }
}
