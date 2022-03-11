package com.scaler.lld.bookmyshow.controllers;

import com.scaler.lld.bookmyshow.dtos.CreateCustomerDTO;
import com.scaler.lld.bookmyshow.models.Customer;
import com.scaler.lld.bookmyshow.services.CustomerService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody CreateCustomerDTO customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

}
