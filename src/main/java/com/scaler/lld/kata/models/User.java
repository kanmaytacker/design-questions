package com.scaler.lld.kata.models;

import lombok.AllArgsConstructor;

// Intrinsic state - Which will not change
@AllArgsConstructor
public class User {
    private String name;
    private String email;
    private String photo;
}
