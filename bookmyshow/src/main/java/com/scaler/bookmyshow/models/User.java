package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "USERS")
public class User extends BaseModel {
    private String email;

    public User(Date createdAt, Date updatedAt, String email) {
        super(createdAt, updatedAt);
        this.email = email;
    }
}

