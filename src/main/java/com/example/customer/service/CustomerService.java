package com.example.customer.service;

import com.example.customer.dto.request.CustomerRequest;
import com.example.customer.dto.response.CustomerResponse;

/**
 * @author Ashraf on 18-Jul-23
 * @project customer
 */

public interface CustomerService {
    void createCustomer(CustomerRequest request);
    CustomerResponse getCustomerById(Long id);
    boolean decreaseBalance(Long id,double amount);
    boolean increaseBalance(Long id,double amount);
}
