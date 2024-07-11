package com.example.bai2_lab3;

public class MenuItem {
    private int imageResourceId;
    private String name;
    private String price;

    public MenuItem(int imageResourceId, String name, String price) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.price = price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
