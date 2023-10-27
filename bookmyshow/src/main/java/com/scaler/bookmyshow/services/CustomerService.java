package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.dtos.CreateCustomerDTO;
import com.scaler.bookmyshow.exceptions.CustomerNotFoundException;
import com.scaler.bookmyshow.exceptions.EmailAlreadyExistsException;
import com.scaler.bookmyshow.models.Customer;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private UserService userService;

    public Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer createCustomer(CreateCustomerDTO request) {
        // Validate if the email is not present
        // If present, throw an error
        String email = request.getEmail();
        Optional<Customer> existingCustomer = customerRepository.findCustomerByEmail(email);
        if (existingCustomer.isPresent()) {
            throw new EmailAlreadyExistsException(email);
        }

        // Create the user
        User user = userService.createUser(request.getUsername(), request.getPassword());

        // Create the customer
        Customer customer = Customer.builder()
                .city(request.getCity())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .fullName(request.getFullName())
                .user(user)
                .build();

        return customerRepository.save(customer);
    }

    public Customer getCustomerInternal(Long userId) {
        return customerRepository.findById(userId).orElse(null);
    }
}

// BREAK 6:02 - 6:10
//        10:40
