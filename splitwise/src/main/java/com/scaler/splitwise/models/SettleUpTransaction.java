package com.scaler.splitwise.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SettleUpTransaction {
    private Long from;
    private Long to;
    private Double amount;
}
