package com.example.SWPhase2.Utils;

import com.example.SWPhase2.Models.Order;

public class ShipmentNotification extends Notification{

    public ShipmentNotification(String subject, ChannelType[] channelType, String[] availableLanguage, Order order) {
        super(subject, channelType, availableLanguage, order);
    }

    @Override
    public String getMessage() {
        return null;
    }
}
