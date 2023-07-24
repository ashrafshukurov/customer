package com.example.customer.service.impl;

import com.example.customer.dto.request.CustomerRequest;
import com.example.customer.dto.response.CustomerResponse;
import com.example.customer.exception.InSufficientBalance;
import com.example.customer.exception.NotFoundException;
import com.example.customer.mapper.CustomerMapper;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Ashraf on 18-Jul-23
 * @project customer
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public void createCustomer(CustomerRequest request) {
        log.info("customer is creating");
        Customer customer=mapper.requestToEntity(request);
        repository.save(customer);

    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        log.info("customer is searching");
        Customer customer=repository.findById(id).orElseThrow(()->new NotFoundException("invalid customer"));
        return mapper.entityToResponse(customer);
    }

    @Override
    public boolean decreaseBalance(Long id,double amount) {
        Customer customer=repository.findById(id).orElseThrow(()->new NotFoundException("invalid customer"));
        if(amount>customer.getBalance()){
            log.warn("you dont have enough money to order");
            throw new InSufficientBalance("Insufficient Balance");
        }
        customer.setBalance(customer.getBalance()-amount);
        repository.save(customer);
        return true;
    }

    @Override
    public void increaseBalance(Long id, double amount) {
        Customer customer=repository.findById(id).orElseThrow(()->new NotFoundException("invalid customer"));
        customer.setBalance(customer.getBalance()+amount);
        repository.save(customer);
    }
}
