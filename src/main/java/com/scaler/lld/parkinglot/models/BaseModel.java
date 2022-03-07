package com.scaler.lld.parkinglot.models;

import java.sql.Date;

import lombok.Data;

@Data
public class BaseModel {
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
