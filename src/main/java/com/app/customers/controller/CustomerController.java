package com.app.customers.controller;

import com.app.customers.entity.Customer;
import com.app.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getById(@PathVariable("customerId") Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public Customer saveUpdate(@RequestBody Customer customer) {
        customerService.saveOrUpdate(customer);
        return customer;
    }

    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable("customerId") Long customerId) {
        customerService.delete(customerId);
    }
}
