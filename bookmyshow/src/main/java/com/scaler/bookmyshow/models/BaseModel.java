package com.scaler.bookmyshow.models;

import lombok.Getter;

import java.util.Date;

@Getter
public abstract class BaseModel {
    private Long id;

    private Date createdAt;

    private Date updatedAt;

}