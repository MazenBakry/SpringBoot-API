package com.example.SWPhase2.Services;

import com.example.SWPhase2.Database.MemoryDB;
import com.example.SWPhase2.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    MemoryDB memoryDB;

    @Autowired
    public AuthServiceImpl(MemoryDB memoryDB) {
        this.memoryDB = memoryDB;
    }

    @Override
    public boolean signUp(Customer customer) {
        Customer[] customers = memoryDB.getCustomers();
        for(Customer c : customers){
            if(c.getUsername().equals(customer.getUsername())){
                return false;
            }
        }
        return memoryDB.addCustomer(customer);

    }

    @Override
    public Customer logIn(String username, String password) {
        Customer customer = memoryDB.getCustomerByUsername(username);
        if(customer == null) return  null;
        if(customer.getPassword().equals(password)){
            return customer;
        }
        return null;
    }
}
