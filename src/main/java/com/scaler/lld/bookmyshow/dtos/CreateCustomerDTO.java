package com.scaler.lld.bookmyshow.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateCustomerDTO {

    private String username;
    private String password;
    private String fullName;
    private String phone;
    private String city;
    private String email;
}
