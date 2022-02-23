package com.example.demo.customer;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Deprecated
public interface CustomerRepo {
    List<Customer>  getCustomers();
}
