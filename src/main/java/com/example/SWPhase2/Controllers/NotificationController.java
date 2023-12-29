package com.example.SWPhase2.Controllers;

import com.example.SWPhase2.Services.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    NotificationServiceImpl notificationService;

    @Autowired
    public NotificationController(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }
    @GetMapping("")
    public ArrayList<String> getNotification(){
        return notificationService.getNotifications();
    }
}
