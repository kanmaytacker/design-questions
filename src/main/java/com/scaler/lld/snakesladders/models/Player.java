package com.scaler.lld.snakesladders.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Player {

   private Colour color;
   private User user;

   @Builder.Default
   private List<Piece> pieces = new ArrayList<>();
}
