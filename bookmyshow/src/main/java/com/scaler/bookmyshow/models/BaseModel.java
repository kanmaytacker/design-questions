package com.scaler.bookmyshow.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class BaseModel {

    private Long id;

    private Date createdAt;

    private Date updatedAt;
}
