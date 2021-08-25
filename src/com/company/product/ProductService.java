package com.company.product;

import java.util.Scanner;

public class ProductService {
    private static Product[] products = new Product[1];
    private Scanner scanner;

    public ProductService(){
        scanner = new Scanner(System.in);
    }

    static{
        products[0] = new Product("My_Product","This is the description",12000);
    }

    public void addProduct(){
        System.out.print("Product Title: ");
        String title = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.println("Price: ");
        int price = scanner.nextInt();
        Product[] updated = new Product[products.length+1];
        for(int i = 0; i < products.length; i++){
            updated[i] = products[i];
        }
        updated[updated.length-1] = new Product(title,description, price);
        products = updated;
    }
}
