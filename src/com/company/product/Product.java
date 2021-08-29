package com.company.product;

public class Product {
    private static int sequence;

    static{
        sequence = 0;
    }
    public final int id;
    public String title;
    public String description;
    public int price;

    public Product(String title, String description, int price){
        this.title = title;
        this.description = description;
        this.price= price;
        this.id = ++sequence;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        String txt = id + " | ";
        txt += title + " | ";
        txt += price + " | ";
        txt += description;
        return txt;
    }
}
