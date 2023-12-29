package com.example.SWPhase2.Services;

import com.example.SWPhase2.Models.Customer;

public interface AuthService {
    boolean signUp(Customer customer);
    Customer logIn(String username, String password);
}
