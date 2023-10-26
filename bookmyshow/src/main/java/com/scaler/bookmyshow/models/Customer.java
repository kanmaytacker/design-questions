package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends BaseModel {

    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;

    @OneToOne
    private User user;
}
// Customer -> fullName, phone, city, email
// User
// Create and GET APIs for Movie, Show, Seat,

