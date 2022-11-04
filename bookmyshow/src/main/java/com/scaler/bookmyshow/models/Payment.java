package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.PaymentMode;
import com.scaler.bookmyshow.enums.PaymentStatus;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Payment {

    private String referenceId;

    private Double amount;

    private PaymentMode mode;

    private PaymentStatus status;


}
