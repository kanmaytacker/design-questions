package com.scaler.lld.kata.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// Intrinsic state - Which will not change
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String email;
    private String photo;
}
