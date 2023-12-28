package com.example.SWPhase2.Services;

import com.example.SWPhase2.Database.MemoryDB;
import com.example.SWPhase2.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    MemoryDB memoryDB;

    @Autowired
    public CustomerServiceImpl(MemoryDB memoryDB) {
        this.memoryDB = memoryDB;
    }
    @Override
    public boolean updateBalance(int id, double amount) {
        Customer customer = memoryDB.getCustomerById(id);
        if(customer  == null){
            return  false;
        }
        customer.setBalance(customer.getBalance()+amount);
        return  memoryDB.updateCustomer(customer);
    }
}
