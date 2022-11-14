package com.scaler.splitwise.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SettleUpTransaction {
    private User from;
    private User to;
    private Double amount;
}
