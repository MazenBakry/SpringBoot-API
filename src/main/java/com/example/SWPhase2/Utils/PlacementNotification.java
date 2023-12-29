package com.example.SWPhase2.Utils;

import com.example.SWPhase2.Database.Database;
import com.example.SWPhase2.Models.Customer;
import com.example.SWPhase2.Models.Order;
import com.example.SWPhase2.Models.Product;

import java.util.ArrayList;

public class PlacementNotification extends Notification{


    public PlacementNotification(String subject, ChannelType[] channelType, String[] availableLanguage, Order order, Database db) {
        super(subject, channelType, availableLanguage, order, db);
    }

    @Override
    public String getMessage() {
        ArrayList<String>items = new ArrayList<>();
        Order order = this.getOrder();
        Database db = this.getDb();
        Customer customer = db.getCustomerById(order.getCustomerId());
        ArrayList<Integer>productsId = order.getProducts();
        for(int pId : productsId){
            Product product = db.getProductById(pId);
            items.add(product.getName());
        }
        String allItems = String.join(", ", items);

        return String.format("Dear %s, your booking of the item(s) %s is confirmed, thanks for using our store :)", customer.getUsername(), allItems);
    }
}
