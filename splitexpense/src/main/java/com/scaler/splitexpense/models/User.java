package com.scaler.splitexpense.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "users")
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}