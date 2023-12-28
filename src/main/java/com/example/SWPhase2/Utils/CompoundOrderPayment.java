package com.example.SWPhase2.Utils;

import com.example.SWPhase2.Database.Database;
import com.example.SWPhase2.Database.MemoryDB;
import com.example.SWPhase2.Models.Customer;
import com.example.SWPhase2.Models.Order;
import com.example.SWPhase2.Models.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class CompoundOrderPayment implements IPay{
    Database db;
    double SHIPPING_FEE = 10;

    public CompoundOrderPayment(Database db) {
        this.db = db;
    }

    @Override
    public boolean pay(Order order) {
        ArrayList<Order>compositeOrders = order.getCompositeOrders();
        double shippingfee = SHIPPING_FEE/(compositeOrders.size()+1);

        compositeOrders.add(order);
        boolean allOrdersSuccess = true;
        HashMap<Integer, Double>customersFees = new HashMap<>();
        ArrayList<Integer>allProducts = new ArrayList<>();

        for(Order o : compositeOrders) {
            double totalAmount = Helper.calculateAmount(db, o);
            ArrayList<Integer>products = o.getProducts();
            for(Integer productId : products){
                allProducts.add(productId);
            }
            Customer customer = db.getCustomerById(o.getCustomerId());
            totalAmount += shippingfee;
            if (totalAmount > customer.getBalance()) {
                allOrdersSuccess = false;
                break;
            }
            customersFees.put(customer.getId(), totalAmount);
        }

        HashMap<Product, Integer> productsNum = Helper.createProductsNum(db, allProducts);
        if(!Helper.CheckAvaliableProducts(db, productsNum)){
            allOrdersSuccess = false;
        }

        if(allOrdersSuccess){
            for(Order o : compositeOrders){
                Customer customer = db.getCustomerById(o.getCustomerId());
                customer.setBalance(customer.getBalance() - customersFees.get(o.getCustomerId()));
                Helper.updateProducts(db, o);
            }
        }

        compositeOrders.remove(order);

        return  allOrdersSuccess;
    }
}
