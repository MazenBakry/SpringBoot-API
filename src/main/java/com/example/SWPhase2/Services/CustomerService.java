package com.example.SWPhase2.Services;

import com.example.SWPhase2.Models.Customer;

public interface CustomerService {
    boolean updateBalance(int id,double amount);
    Customer[] getCustomers();
}
