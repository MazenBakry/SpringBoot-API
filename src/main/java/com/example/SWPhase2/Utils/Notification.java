package com.example.SWPhase2.Utils;

import com.example.SWPhase2.Models.Order;

public abstract class Notification {
    String subject;
    ChannelType[] channelType;
    String[] availableLanguage;
    Order order;

    public Notification(String subject, ChannelType[] channelType, String[] availableLanguage, Order order) {
        this.subject = subject;
        this.channelType = channelType;
        this.availableLanguage = availableLanguage;
        this.order = order;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ChannelType[] getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType[] channelType) {
        this.channelType = channelType;
    }

    public String[] getAvailableLanguage() {
        return availableLanguage;
    }

    public void setAvailableLanguage(String[] availableLanguage) {
        this.availableLanguage = availableLanguage;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public abstract String getMessage();
}
