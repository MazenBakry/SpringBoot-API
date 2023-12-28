package com.example.SWPhase2.Services;

import com.example.SWPhase2.Database.MemoryDB;
import com.example.SWPhase2.Models.OrderType;
import com.example.SWPhase2.Utils.CompoundOrderPayment;
import com.example.SWPhase2.Utils.SimpleOrderPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SWPhase2.Models.Order;


@Service
public class OrderServiceImpl implements OrderService{
    MemoryDB memoryDB;

    @Autowired
    public OrderServiceImpl(MemoryDB memoryDB) {
        this.memoryDB = memoryDB;
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
        return memoryDB.addOrder(order);
    }
    @Override
    public boolean removeOrder (int id){
        return false ;
    };
    @Override
    public Order[] getOrders(){
        return memoryDB.getOrders();
    };

}
