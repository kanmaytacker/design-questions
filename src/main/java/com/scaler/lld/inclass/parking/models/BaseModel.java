package com.scaler.lld.inclass.parking.models;

import java.sql.Date;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
