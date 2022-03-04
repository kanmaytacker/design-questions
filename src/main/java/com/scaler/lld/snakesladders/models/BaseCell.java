package com.scaler.lld.snakesladders.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class BaseCell extends Cell {

    @Override
    public Integer getNextPosition() {
        return getIndex();
    }

}
