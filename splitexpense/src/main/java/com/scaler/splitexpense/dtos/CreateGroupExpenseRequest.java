package com.scaler.splitexpense.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class CreateGroupExpenseRequest {
    private String description;
    private Double amount;
    private Long groupId;
    private List<Long> userIds = new ArrayList<>();
}
