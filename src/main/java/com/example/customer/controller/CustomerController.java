package com.example.customer.controller;

import com.example.customer.dto.response.CustomerResponse;
import com.example.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ashraf on 18-Jul-23
 * @project customer
 */
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id){
      return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/dec/{id}/{amount}")
    public ResponseEntity<Boolean> decreaseBalance(@PathVariable Long id,@PathVariable double amount){
        return ResponseEntity.ok(customerService.decreaseBalance(id,amount));
    }
    @GetMapping("/inc/{id}/{amount}")
    public ResponseEntity<Boolean> increaseBalance(@PathVariable Long id,@PathVariable double amount){
      return ResponseEntity.ok(customerService.increaseBalance(id,amount))  ;
    }

}
