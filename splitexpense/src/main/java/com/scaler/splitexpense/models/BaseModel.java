package com.scaler.splitexpense.models;

import lombok.Getter;

import java.util.Date;

@Getter
public class BaseModel {

    private Long id;
    private Date createdAt;
    private Date updatedAt;
}