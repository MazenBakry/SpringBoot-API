package com.example.SWPhase2.Controllers;

import com.example.SWPhase2.Models.Customer;
import com.example.SWPhase2.Services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }
    @PutMapping("/balance")
    public ResponseEntity<String> updateBalance(@RequestBody Customer customer){
        if(customerService.updateBalance(customer.getId(), customer.getBalance())){
            return new ResponseEntity<>("Balance updated successfully", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Can't update balance ", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public Customer[] getCustomers(){
        return customerService.getCustomers();
    }
}
