package com.example.SWPhase2.Models;

public class Product {
    private int serialNumber;
    private String name;
    private String vendorName;
    private String category;
    private double price;
    private int amountAvailable;

    public Product(int serialNumber, String name, String vendorName, String category, double price, int amountAvailable) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.vendorName = vendorName;
        this.category = category;
        this.price = price;
        this.amountAvailable = amountAvailable;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }
}
