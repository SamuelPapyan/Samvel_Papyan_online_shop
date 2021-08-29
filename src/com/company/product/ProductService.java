package com.company.product;

import java.util.Scanner;

public class ProductService {
    private static Product[] products = new Product[3];
    private Scanner scanner;

    public ProductService(){
        scanner = new Scanner(System.in);
    }

    static{
        products[0] = new Product("ENDO T-shirt","T-shirt XXL Size",12000);
        products[1] = new Product("ENDO USB Flash Drive","USB Flash Drive 64GB Memory",5600);
        products[2] = new Product("ENDO Poster","Poster A3 Size",2600);
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

    public Product findProductById(int id){
        for(Product item : products){
            if(item.getId() == id)
                return item;
        }
        return null;
    }

    public static Product[] getProducts() {
        return products;
    }
}
