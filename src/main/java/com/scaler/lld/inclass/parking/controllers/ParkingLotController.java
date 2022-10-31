package com.scaler.lld.inclass.parking.controllers;

import com.scaler.lld.inclass.parking.dtos.CreateLotRequest;
import com.scaler.lld.inclass.parking.models.ParkingLot;
import com.scaler.lld.inclass.parking.services.ParkingLotService;

import lombok.AllArgsConstructor;

// Controllers should be extremely dumb. Delegate calls to service 
// 1. Request validation - id, name, address
// 2. Transformation/Data mapping - CreateLotRequest - ParkingLot -
// Request DTOs -> Models
// 
@AllArgsConstructor
public class ParkingLotController {

    private ParkingLotService service;

    // 1. Create parking lot
    public ParkingLot createParkingLot(CreateLotRequest request) {

        // Validate request DTOs
        validate(request);

        // 2. Data mapping
        return service.createParkingLot(request.toParkingLot());
    }

    private void validate(CreateLotRequest request) {
        if (request.getId() == null) {
            throw new RuntimeException("Id cannot be null");
        }
    }

    // 2. Update parking lot
    // 3. Read parking lot
    // 4. Delete parking lot
}

// How to structure controllers
// Entity level
// - A lot of classes
// - Easier to find/ maintainble
// Usecase based/Flow based
// - EntryFlowController
// - ExitFlowController
// - Related code is together
// - Very hard to find a single API
// Jackson - Mixin

// Request (DTO) - Controller
// Controller DTO -> validation
// Controller DTO -> Model
// Controller -> Service ->
// Service -> Repository -> Save entity to DB

// POST /parking-lot/
// Request ----- Response
// { name: "A", address: "B"} --> { id: 1, name: "A", address: "B"}

// { name: "A", address: "B"} --> { id: 2, name: "A", address: "B"}
// Not idempotent - Since there is no ID I cannot deduplication

// PUT /parking-lot/:id
//