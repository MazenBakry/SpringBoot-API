package com.example.SWPhase2.Database;

import com.example.SWPhase2.Models.Customer;
import com.example.SWPhase2.Models.Product;
import org.springframework.stereotype.Repository;

import java.net.Inet4Address;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryDB implements Database{
    HashMap<Integer, Product>products = new HashMap<Integer, Product>();
    HashMap<Integer, Customer>customers = new HashMap<Integer, Customer>();

    int nextCustomerId = 0;

    MemoryDB(){
        products.put(1, new Product(1, "kdfla", "dkajf", "fajdf", 23.3, 15));
    }

    @Override
    public Product[] getProducts() {
        Product[] allProducts = new Product[products.size()];
        int cnt = 0;
        for(Map.Entry<Integer, Product> productEntry : products.entrySet()){
            allProducts[cnt] = productEntry.getValue();
            cnt++;
        }
        return  allProducts;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        int id = nextCustomerId++;
        customer.setId(id);
        customers.put(id, customer);
        return  true;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        for(Map.Entry<Integer, Customer> customerEntry : customers.entrySet()){
            if(customerEntry.getValue().getUsername().equals(username)){
                return customerEntry.getValue();
            }
        }
        return null;
    }

    @Override
    public Customer[] getCustomers(){
        Customer[] customerArray = customers.values().toArray(new Customer[0]);
        return customerArray;
    }

}
