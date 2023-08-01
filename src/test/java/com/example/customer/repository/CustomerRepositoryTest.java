package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ashraf on 01-Aug-23
 * @project customer
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
@EnableConfigurationProperties
@EnableJpaRepositories
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Test
    @Sql(scripts = "classpath:sql/customer.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
   public void givenFindByIdCustomerWhenFoundThenReturnEntity(){
       //arrange
      Long id=2L;
       //act
       Optional<Customer> response=customerRepository.findById(id);
       //assert
       Customer customer=response.get();
       assertEquals(id,customer.getId());
    }
}