package com.example.SWPhase2.Services;

import com.example.SWPhase2.Database.Database;
import com.example.SWPhase2.Models.Order;
import com.example.SWPhase2.Models.OrderStatus;
import com.example.SWPhase2.Utils.Notification;
import com.example.SWPhase2.Utils.NotificationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class NotificationServiceImpl implements NotificationService{


    Queue<Notification> notificationsList = new LinkedList<>();




    @Override
    public void sendNotification(Order order, Database db) {
        NotificationFactory notificationFactory = new NotificationFactory(db);
        Notification orderPlacement = notificationFactory.createNotification("Placement", order);
        notificationsList.add(orderPlacement);
        Thread notificationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(60000);
                    Notification shipmentPlacement = notificationFactory.createNotification("Shipment", order);
                    order.setOrderStatus(OrderStatus.DELIVERED);
                    notificationsList.add(shipmentPlacement);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        notificationThread.start();
    }
}
