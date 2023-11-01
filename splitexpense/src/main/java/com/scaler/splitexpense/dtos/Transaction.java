package com.scaler.splitexpense.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
    private Long from;
    private Long to;
    private Double amount;
}