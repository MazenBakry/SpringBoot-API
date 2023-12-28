package com.example.SWPhase2.Utils;

import com.example.SWPhase2.Models.Order;

public class PlacementNotification extends Notification{

    public PlacementNotification(String subject, ChannelType[] channelType, String[] availableLanguage, Order order) {
        super(subject, channelType, availableLanguage, order);
    }

    @Override
    public String getMessage() {
        return null;
    }
}
