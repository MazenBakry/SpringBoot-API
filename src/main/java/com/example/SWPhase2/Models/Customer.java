package com.example.SWPhase2.Models;

public class Customer {
    private int id;
    private double balance;
    private String username;
    private String password;

    public Customer(int id, double balance, String username, String password) {
        this.id = id;
        this.balance = balance;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
