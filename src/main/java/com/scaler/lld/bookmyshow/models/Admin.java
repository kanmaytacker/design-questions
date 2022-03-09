package com.scaler.lld.bookmyshow.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "ADMINS")
public class Admin extends Auditable {

    private String designation;
    private String phone1, phone2, phone3;
    private Long numberOfYearsInTheCompany;

    @OneToOne
    private User user;
}
