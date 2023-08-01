package com.example.customer.controller;

import com.example.customer.CustomerApplication;
import com.example.customer.dto.ErrorResponse;
import com.example.customer.dto.response.CustomerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ashraf on 01-Aug-23
 * @project customer
 */
@SpringBootTest(classes = CustomerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class CustomerControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String url;

    @BeforeEach
    void setUp() {
        this.url = "http://localhost:" + port;
    }

    @Test
    @Sql(scripts = "classpath:sql/customer.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void givenFindByIdCustomerWhenFoundThenReturnEntity() {
        //arrange
        Long id = 2L;
        //act
        ResponseEntity<CustomerResponse> response = testRestTemplate.getForEntity(url + "/" + id, CustomerResponse.class);
        //assert
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void givenFindByIdCustomerWhenNotFoundThenReturnException() {
        //arrange
        Long id = 100L;
        //act
        ResponseEntity<ErrorResponse> response = testRestTemplate.getForEntity(url + "/" + id, ErrorResponse.class);
        //assert
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }
}