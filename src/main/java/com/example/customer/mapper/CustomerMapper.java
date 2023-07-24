package com.example.customer.mapper;

import com.example.customer.dto.request.CustomerRequest;
import com.example.customer.dto.response.CustomerResponse;
import com.example.customer.model.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Ashraf on 18-Jul-23
 * @project customer
 */


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer requestToEntity(CustomerRequest request);
    CustomerResponse entityToResponse(Customer customer);
}
