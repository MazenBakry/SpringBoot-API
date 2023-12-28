package com.example.SWPhase2.Utils;

import com.example.SWPhase2.Models.Order;

public class NotificationFactory {
    public Notification createNotification(String type, Order order){
        if(type.equalsIgnoreCase("Placement")){
          //  return new PlacementNotification();
        }
        else if(type.equalsIgnoreCase("Shipment")){
           // return new PlacementNotification();
        }
        return null;
    }
}
