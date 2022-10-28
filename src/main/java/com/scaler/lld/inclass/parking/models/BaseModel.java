package com.scaler.lld.inclass.parking.models;

import java.sql.Date;

import lombok.Data;

@Data
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
