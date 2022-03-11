package com.scaler.lld.bookmyshow.services;

import com.scaler.lld.bookmyshow.dtos.CreateCustomerDTO;
import com.scaler.lld.bookmyshow.dtos.CreateUserDTO;
import com.scaler.lld.bookmyshow.models.Customer;
import com.scaler.lld.bookmyshow.models.User;
import com.scaler.lld.bookmyshow.repositories.interfaces.CustomerRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserService userService;

    public Customer createCustomer(CreateCustomerDTO customerRequest) {
        if (userService.doesUserExist(customerRequest.getUsername(), customerRequest.getEmail())) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = userService.createUser(
                new CreateUserDTO(customerRequest.getUsername(), customerRequest.getPassword(), "CUSTOMER"));

        Customer customer = Customer
                .builder()
                .city(customerRequest.getCity())
                .email(customerRequest.getEmail())
                .phone(customerRequest.getPhone())
                .user(user)
                .build();
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository.getById(customerId);
    }

}
