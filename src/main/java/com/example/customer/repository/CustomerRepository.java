package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Ashraf on 18-Jul-23
 * @project customer
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findById(Long id);
}
