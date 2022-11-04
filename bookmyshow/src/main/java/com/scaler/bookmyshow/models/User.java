package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class User extends BaseModel {
    private String email;
}

