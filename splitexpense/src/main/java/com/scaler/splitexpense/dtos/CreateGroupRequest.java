package com.scaler.splitexpense.dtos;

import com.scaler.splitexpense.models.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class CreateGroupRequest {
    private String name;
    private Long createdBy;
    private List<Long> memberIds = new ArrayList<>();
}
