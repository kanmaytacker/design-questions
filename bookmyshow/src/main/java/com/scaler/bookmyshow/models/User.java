package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
public class User extends BaseModel {
    private String email;

    public User(Long id, Date createdAt, Date updatedAt, String email) {
        super(id, createdAt, updatedAt);
        this.email = email;
    }
}

