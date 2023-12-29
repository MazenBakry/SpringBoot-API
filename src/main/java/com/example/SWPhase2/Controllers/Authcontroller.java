package com.example.SWPhase2.Controllers;

import com.example.SWPhase2.Models.Customer;
import com.example.SWPhase2.Services.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class Authcontroller {

    AuthServiceImpl authService;

    @Autowired
    public Authcontroller(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Customer customer){
        boolean isSuccess = authService.signUp(customer);
        if(isSuccess){
            return  new ResponseEntity<>("Signed Up Successfully, your id is " + customer.getId() , HttpStatus.CREATED);
        }
        return  new ResponseEntity<>("username already taken", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Customer credential){
        Customer customer = authService.logIn(credential.getUsername(), credential.getPassword());
        if(customer == null){
            return new ResponseEntity<>("Login Failed", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("Logged in Successfully, your id is " + customer.getId(), HttpStatus.OK);
    }





}
