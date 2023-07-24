package com.example.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Ashraf on 18-Jul-23
 * @project customer
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pinCode;
    private String name;
    private String surName;
    private int age;
    private String address;
    private double balance;

}
