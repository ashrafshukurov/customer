package com.example.customer.service.impl;

import com.example.customer.dto.response.CustomerResponse;
import com.example.customer.exception.InSufficientBalance;
import com.example.customer.exception.NotFoundException;
import com.example.customer.mapper.CustomerMapper;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ashraf on 26-Jul-23
 * @project customer
 */

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;
    @Mock
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setName("Ashraf");
        customer.setAddress("Sumgait");
        customer.setPinCode(1231212L);
        customer.setAge(20);
        customer.setSurName("Shukurov");
        customer.setBalance(700);
    }


    @Test
    public void givenGetCustomerByIdWhenFoundThenReturnResult() {
        //arrange
        Long customer_id = 1L;
        customer.setId(customer_id);

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setBalance(700);
        customerResponse.setId(customer_id);
        customerResponse.setSurName("Shukurov");
        customerResponse.setName("Ashraf");
        customerResponse.setPinCode(1231212L);
        customerResponse.setAge(20);

        Mockito.when(customerRepository.findById(customer_id)).thenReturn(Optional.of(customer));

        Mockito.when(customerMapper.entityToResponse(customer)).thenReturn(customerResponse);

        //act

        CustomerResponse customerResponse1 = customerServiceImpl.getCustomerById(customer_id);

        //assert
        assertEquals(700, customerResponse.getBalance());

    }

    @Test
    public void givenGetCustomerByIdWhenNotFoundThenThrowException404() {
        //assert
        Long customer_id = 1L;

        Mockito.when(customerRepository.findById(customer_id)).thenReturn(Optional.empty());
        //act & assert

        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> customerServiceImpl.getCustomerById(customer_id));

        assertEquals("invalid customer", notFoundException.getMsg());
    }

    @Test
    public void givenDecreaseBalanceWhenFoundThenReturnResult() {
        //arrange
        Long customer_id = 1L;
        int decrease_amount=200;
        int initial_amount=700;
        Customer customer1=new Customer();
        customer1.setSurName("Shukurov");
        customer1.setBalance(initial_amount);
        customer1.setAddress("Sumgait");
        customer1.setAge(20);
        customer1.setId(customer_id);
        customer1.setPinCode(123456L);
        Mockito.when(customerRepository.findById(customer_id)).thenReturn(Optional.of(customer1));
        //act
        boolean result=customerServiceImpl.decreaseBalance(customer_id,decrease_amount);
        //assert
        assertEquals(initial_amount-decrease_amount,customer1.getBalance());
    }
    @Test
    public void givenDecreaseBalanceWhenNotFoundThenThrowException404(){
        Long customer_id=1L;
        double decrease_amount=200;
        Mockito.when(customerRepository.findById(customer_id)).thenReturn(Optional.empty());
        //assert & act
        NotFoundException notFoundException=assertThrows(NotFoundException.class,()->customerServiceImpl.decreaseBalance(customer_id,decrease_amount));

        assertEquals("invalid customer",notFoundException.getMsg());

    }
    @Test
    public void givenDecreaseBalanceWhenNotFoundThenThrowInsufficientException(){
        //arrange
     Long id=1L;
     double decrease_amount=900;
     double initial_amount=700;
     Customer customer1=new Customer();
        customer1.setName("Ashraf");
        customer1.setAddress("Sumgait");
        customer1.setPinCode(1231212L);
        customer1.setAge(20);
        customer1.setSurName("Shukurov");
        customer1.setBalance(initial_amount);

     Mockito.when(customerRepository.findById(id)).thenReturn(Optional.of(customer));

     //assert & act
        InSufficientBalance inSufficientBalance=assertThrows(InSufficientBalance.class,()->customerServiceImpl.decreaseBalance(id,decrease_amount));
        assertEquals("Insufficient Balance",inSufficientBalance.getMsg());
    }
    @Test
    public void givenIncreaseBalanceWhenFoundThenReturnResult(){
        //arrange
        Long customer_id=1L;
        double increase_amount=200;
        double initial_amount=300;
        Customer customer1=new Customer();
        customer1.setName("Ashraf");
        customer1.setAddress("Sumgait");
        customer1.setPinCode(1231212L);
        customer1.setAge(20);
        customer1.setSurName("Shukurov");
        customer1.setBalance(initial_amount);
        Mockito.when(customerRepository.findById(customer_id)).thenReturn(Optional.of(customer1));
        //act
        customerServiceImpl.increaseBalance(customer_id,increase_amount);
        //assert
        assertEquals(initial_amount+increase_amount,customer1.getBalance());
    }
    @Test
    public void givenIncreaseBalanceWhenNotFoundThenThrowException404(){
        Long customer_id=1L;
        double increase_amount=100;
        Mockito.when(customerRepository.findById(customer_id)).thenReturn(Optional.empty());

        NotFoundException notFoundException=assertThrows(NotFoundException.class,()->customerServiceImpl.increaseBalance(customer_id,increase_amount));

        assertEquals("invalid customer",notFoundException.getMsg());

    }
}