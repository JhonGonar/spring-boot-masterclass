package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController
@AllArgsConstructor
public class CustomerControllerV2 {

    private final CustomerService customerService;

    /*public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }*/

    @GetMapping/*(value = "all")*/
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id);
    }

    //not real path, just for demonstration purpose
    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id){
        throw new ApiRequestException("api request exception for customer "+ id);
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer){
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
