package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.PaymentMode;
import com.scaler.bookmyshow.enums.PaymentStatus;
import lombok.Getter;

import java.util.Date;

@Getter
public class Payment extends BaseModel {

    private final String referenceId;

    private final Double amount;

    private final PaymentMode mode;

    private final PaymentStatus status;

    public Payment(Long id, Date createdAt, Date updatedAt, String referenceId, Double amount, PaymentMode mode, PaymentStatus status) {
        super(id, createdAt, updatedAt);
        this.referenceId = referenceId;
        this.amount = amount;
        this.mode = mode;
        this.status = status;
    }
}
