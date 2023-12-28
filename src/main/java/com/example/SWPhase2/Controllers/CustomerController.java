package com.example.SWPhase2.Controllers;

import com.example.SWPhase2.Services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/balance/{customerId}/{balance}")
    public ResponseEntity<String> updateBalance(@PathVariable int customerId, @PathVariable double balance){
        if(customerService.updateBalance(customerId,balance)){
            return new ResponseEntity<>("Balance updated successfully", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Can't update balance ", HttpStatus.BAD_REQUEST);
    }
}
