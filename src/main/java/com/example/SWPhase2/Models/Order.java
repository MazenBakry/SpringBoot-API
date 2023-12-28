package com.example.SWPhase2.Models;

import com.example.SWPhase2.Utils.IPay;

import java.util.ArrayList;

public class Order {
    private int id;
    private OrderStatus orderStatus;
    private OrderType orderType;
    private ArrayList<Integer> products;
    private int customerId;

    private  ArrayList<Order> compositeOrders;

    private IPay payUtil;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Order(String orderType, ArrayList<Integer> products, int customerId, ArrayList<Order> compositeOrders) {
        this.orderType = orderType.equals("Simple") ? OrderType.SIMPLE : OrderType.COMPOUND;
        this.products = products;
        this.customerId = customerId;
        this.compositeOrders = compositeOrders;
    }

    public void setPayUtil(IPay payUtil) {
        this.payUtil = payUtil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public ArrayList<Integer> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Integer> products) {
        this.products = products;
    }
    public boolean pay(){
        return  payUtil.pay(this);
    }

    public ArrayList<Order> getCompositeOrders(){
        return  compositeOrders;
    }
}

