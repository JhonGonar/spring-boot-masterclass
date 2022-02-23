package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    //Slf4j lomnok annotation replace, now use log....
    /*private final static Logger LOGGER =
            LoggerFactory.getLogger(CustomerService.class); //Logger its an interface , facade foe ease the switching of implementations later*/

    private final CustomerRepository customerRepository;

    //@Autowired
    /*public CustomerService(*//*@Qualifier("fake") *//*CustomerRepository customerRepo) {
        this.customerRepository = customerRepo;
    }*/

    List<Customer> getCustomers(){
        log.info("getCustomers method was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id){

        return customerRepository.findById(id)
                /*getCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()*/
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException("customer with id " + id + " not found");
                            log.error("errro getting customer {}", id, notFoundException);
                            return notFoundException;
                        });
    }
}
