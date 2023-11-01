package com.scaler.splitexpense.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}