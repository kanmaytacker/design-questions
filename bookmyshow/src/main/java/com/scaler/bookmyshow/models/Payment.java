package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.PaymentMethodType;
import com.scaler.bookmyshow.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel {

    private String reference;
    private Double amount;

    private PaymentMethodType providerType;

    private PaymentStatus status;
}