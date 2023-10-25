package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.dtos.CreateCustomerDTO;
import com.scaler.bookmyshow.exceptions.CustomerNotFoundException;
import com.scaler.bookmyshow.models.Customer;
import com.scaler.bookmyshow.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer createCustomer(CreateCustomerDTO request) {
        return null;
    }
}

// BREAK 6:02 - 6:10
//        10:40
