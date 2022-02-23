package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //This for using real database and not mock it
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;



    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer jamila = new Customer(2001L,
                "jamila",
                "hello",
                "jamil@mail.com"
                );
        Customer al = new Customer(20002L,
                "ali",
                "pass3",
                "ali@mail.com");

        customerRepository.saveAll(Arrays.asList(jamila, al));

        //when
        List<Customer> customers = underTest.getCustomers();
        //then
        assertEquals(1002, customers.size());

    }

    @Test
    void getCustomer() {
        Customer jamila = new Customer(2001L,
                "jamila",
                "hello",
                "jamil@mail.com"
        );
        customerRepository.save(jamila);
        Customer actual = underTest.getCustomer(2001L);
        assertEquals(2001L, actual.getId());
        assertEquals("jamila", actual.getName());
        assertEquals("hello", actual.getPassword());
        assertEquals("jamil@mail.com", actual.getEmail());
    }
}