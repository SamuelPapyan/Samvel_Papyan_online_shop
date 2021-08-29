package com.company.admin;

import com.company.user.*;
import com.company.product.ProductService;

public class Admin extends User implements Auth{

    public Admin(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName, userName, password);
    }

    public void addProduct() {
        productService.addProduct();
    }

    public String toString(){
        String txt = "Admin | " + getFirstName() + " " + getLastName() + " | ";
        txt += getUserName();
        return txt;
    }
}
