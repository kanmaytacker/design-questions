package com.scaler.lld.bookmyshow.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "CUSTOMERS")
public class Customer extends Auditable {
    private String fullName;
    private String phone;
    private String city;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings = new ArrayList<>();

    @OneToOne
    private User user;
}
