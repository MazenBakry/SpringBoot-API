package com.example.SWPhase2.Services;


import com.example.SWPhase2.Database.Database;
import com.example.SWPhase2.Models.Order;

public interface NotificationService {
    void sendNotification(Order order, Database db);
}
