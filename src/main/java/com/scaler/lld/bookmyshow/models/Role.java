package com.scaler.lld.bookmyshow.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "ROLES")
public class Role extends Auditable {
    private String name;
    private String description;
}
