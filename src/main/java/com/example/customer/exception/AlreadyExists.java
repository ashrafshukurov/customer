package com.example.customer.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Ashraf on 19-Jul-23
 * @project customer
 */

public class AlreadyExists extends RuntimeException{
   private HttpStatus status=HttpStatus.CONFLICT;


}
