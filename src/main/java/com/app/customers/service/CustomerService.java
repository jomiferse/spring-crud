package com.app.customers.service;

import com.app.customers.entity.Customer;
import com.app.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public void saveOrUpdate(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
