package com.example.SWPhase2.Controllers;



import com.example.SWPhase2.Models.Order;
import com.example.SWPhase2.Services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/")
    public ResponseEntity<String> placeOrder(@RequestBody Order o){
        if(orderService.placeOrder(o)){
            return new ResponseEntity<>("Order placed Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Order was declined", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/")
    public Order[] getOrder(){
        return orderService.getOrders();
    }
    /*
    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<String> removeOrder(@PathVariable int id){
        orderService.removeOrder(id);
    }
   */
}
