package com.example.customer.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author Ashraf on 19-Jul-23
 * @project customer
 */

@Data
public class ErrorResponse {
    private HttpStatus status;
    private String errorMessage;
    private LocalDateTime localDateTime;
    private int errorCode;
}
