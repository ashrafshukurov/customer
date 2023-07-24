package com.example.customer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ashraf on 18-Jul-23
 * @project customer
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

   private Long id;
   private Long pinCode;
   private String name;
   private String surName;
   private int age;
   private String address;
   private double balance;

}
