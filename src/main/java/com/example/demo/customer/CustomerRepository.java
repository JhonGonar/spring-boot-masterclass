package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

//@Repository now instantiated on @Config
//@Primary removed since coming from @Config
@Repository
public interface CustomerRepository/* implements CustomerRepo*/ extends JpaRepository<Customer, Long> {

    /*@Override
    public List<Customer> getCustomers() {
        //TODO Connect ro real data base
        return Collections.singletonList(
                new Customer(1L, "TODO Implement real db", "todo", "email@mail.com")
        );
    }*/
}
