package com.example.SWPhase2.Services;

import com.example.SWPhase2.Models.Order;
import com.example.SWPhase2.Utils.Notification;

import java.util.Queue;

public class NotificationServiceImpl implements NotificationService{

    Queue<Notification> notificationsList;

    public NotificationServiceImpl(Queue<Notification> notificationsList) {
        this.notificationsList = notificationsList;
    }

    @Override
    public void sendNotification(Order order) {
        return;
    }
}
