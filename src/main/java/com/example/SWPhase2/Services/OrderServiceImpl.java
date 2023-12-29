package com.example.SWPhase2.Services;

import com.example.SWPhase2.Database.MemoryDB;
import com.example.SWPhase2.Models.OrderStatus;
import com.example.SWPhase2.Models.OrderType;
import com.example.SWPhase2.Utils.CompoundOrderPayment;
import com.example.SWPhase2.Utils.NotificationFactory;
import com.example.SWPhase2.Utils.SimpleOrderPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SWPhase2.Models.Order;


@Service
public class OrderServiceImpl implements OrderService{
    MemoryDB memoryDB;
    NotificationServiceImpl notificationService;

    @Autowired
    public OrderServiceImpl(MemoryDB memoryDB, NotificationServiceImpl notificationService) {
        this.memoryDB = memoryDB;
        this.notificationService = notificationService;
    }

    @Override
    public boolean placeOrder (Order order){
        if(order.getOrderType() == OrderType.SIMPLE) {
            order.setPayUtil(new SimpleOrderPayment(memoryDB));
        }
        else if(order.getOrderType() == OrderType.COMPOUND) {
            order.setPayUtil(new CompoundOrderPayment(memoryDB));
        }else{
            return  false;
        }
        boolean isPaidSuccessfully = order.pay();
        if(!isPaidSuccessfully)  return false;
        boolean isSuccess =  memoryDB.addOrder(order);
        if(isSuccess){
            notificationService.sendNotification(order, memoryDB);
            return  true;
        }
        return  false;
    }
    @Override
    public boolean removeOrder (int id){
        Order order = memoryDB.getOrderById(id);
        if(order.getOrderStatus() != OrderStatus.DELIVERED){
            order.setOrderStatus(OrderStatus.CANCELLED);
            return true;
        }
        return  false;

    };
    @Override
    public Order[] getOrders(){
        return memoryDB.getOrders();
    };

}
