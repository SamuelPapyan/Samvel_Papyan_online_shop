package com.company.admin;

import com.company.user.User;
import com.company.product.ProductService;

public class Admin extends User{

    private ProductService productService;

    public Admin(String firstName, String lastName, String userName, String password){
        super(firstName,lastName,userName,password);
        productService = new ProductService();
    }
    public void addProduct(){
        productService.addProduct();
    }
}
