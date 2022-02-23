package com.example.demo.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/customers")
@RestController
@Deprecated
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping
    void createNewCustomer(@RequestBody Customer customer){
        System.out.println("POST REQUETS...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE   REQUETS...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST OF CUSTOMER WITH ID " + id);
    }
}
