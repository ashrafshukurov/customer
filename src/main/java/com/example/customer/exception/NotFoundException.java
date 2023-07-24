package com.example.customer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author Ashraf on 19-Jul-23
 * @project customer
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotFoundException extends RuntimeException {
    private final HttpStatus httpStatus=HttpStatus.NOT_FOUND;
    private String msg;
}
