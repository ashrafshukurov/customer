package com.example.customer.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * @author Ashraf on 19-Jul-23
 * @project customer
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InSufficientBalance extends RuntimeException{
    private final HttpStatus httpStatus=HttpStatus.BAD_REQUEST;
    private String msg;

}
