package com.example.SWPhase2.Database;
import com.example.SWPhase2.Models.Customer;
import com.example.SWPhase2.Models.Product;
public interface Database {
     Product[] getProducts();
     boolean addCustomer(Customer customer);
     Customer getCustomerByUsername(String username);
     Customer[] getCustomers();

}
