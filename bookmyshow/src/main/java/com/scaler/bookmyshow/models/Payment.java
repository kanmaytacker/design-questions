package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.PaymentMode;
import com.scaler.bookmyshow.enums.PaymentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Payment extends BaseModel {

    @Enumerated
    private PaymentMode mode;

    @Enumerated
    private PaymentStatus status;
    private Double amount;
    private String referenceId;

    @ManyToOne
    private Ticket ticket;

    public Payment(Date createdAt, Date updatedAt, String referenceId, Double amount, PaymentMode mode, PaymentStatus status) {
        super(createdAt, updatedAt);
        this.referenceId = referenceId;
        this.amount = amount;
        this.mode = mode;
        this.status = status;
    }
}
