package com.example.SWPhase2.Services;

import com.example.SWPhase2.Models.Order;


public interface OrderService {
    public boolean placeOrder (Order order);
    public boolean removeOrder (int id);
    public Order[] getOrders();
}
