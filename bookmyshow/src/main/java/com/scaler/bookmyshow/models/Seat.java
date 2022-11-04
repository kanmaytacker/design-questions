package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.SeatType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
public class Seat extends BaseModel {

    private Integer rowNumber;
    private Integer columnNumber;

    @Enumerated
    private SeatType type;

    public Seat(Date createdAt, Date updatedAt, Integer row, Integer column, SeatType type) {
        super(createdAt, updatedAt);
        this.rowNumber = row;
        this.columnNumber = column;
        this.type = type;
    }
}
