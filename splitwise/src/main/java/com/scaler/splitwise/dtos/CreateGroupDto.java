package com.scaler.splitwise.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateGroupDto {
    private String name;
    private List<Long> admins = new ArrayList<>();
    private List<Long> members = new ArrayList<>();
    private Long createdBy;
}
