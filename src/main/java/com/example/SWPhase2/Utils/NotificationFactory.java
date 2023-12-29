package com.example.SWPhase2.Utils;

import com.example.SWPhase2.Database.Database;
import com.example.SWPhase2.Models.Order;

import java.nio.channels.Channel;

public class NotificationFactory {
    Database db;

    public NotificationFactory(Database db) {
        this.db = db;
    }

    public Notification createNotification(String type, Order order){
        ChannelType [] types = {ChannelType.SMS};
        String[] langs = {"en", "fr"};
        if(type.equalsIgnoreCase("Placement")){
            return new PlacementNotification("Order Placement", types, langs, order, db);
        }
        else if(type.equalsIgnoreCase("S")){
            return new ShipmentNotification("Order Shipped", types,langs,order, db);
        }
        return null;
    }
}
