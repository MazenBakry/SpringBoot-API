package com.example.SWPhase2.Utils;

import com.example.SWPhase2.Database.Database;
import com.example.SWPhase2.Database.MemoryDB;
import com.example.SWPhase2.Models.Customer;
import com.example.SWPhase2.Models.Order;
import com.example.SWPhase2.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleOrderPayment implements IPay {
    Database db;

    int SHIPPING_FEE = 10;
    public SimpleOrderPayment(Database db) {
        this.db = db;
    }
    @Override
    public boolean pay(Order order) {
        double totalAmount = Helper.calculateAmount(db, order);
        Customer customer = db.getCustomerById(order.getCustomerId());
        totalAmount += SHIPPING_FEE;
        ArrayList<Integer> allProducts = order.getProducts();
        HashMap<Product, Integer> productsNum = Helper.createProductsNum(db, allProducts);
        if(totalAmount<=customer.getBalance()){
            if(!Helper.CheckAvaliableProducts(db, productsNum)){
                return  false;
            }
            customer.setBalance(customer.getBalance()-totalAmount);
            Helper.updateProducts(db, order);
            return true;
        }
        return false;
    }
}
