package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

//@Primary //redundant after @Qualifier
//@Repository(value = "fake")//generic name to be identified latter by Spring in the Application Context
// now instantiated on @Config
public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Record example", "password123", "email@mail.com"),
                new Customer(2L, "Jamila Ahmed", "123password", "email@mail.com")
        );
    }
}
