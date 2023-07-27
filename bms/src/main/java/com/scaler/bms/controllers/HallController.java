package com.scaler.bms.controllers;

import com.scaler.bms.dtos.CreateHallRequest;
import com.scaler.bms.models.Hall;
import com.scaler.bms.services.HallService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HallController {
    private HallService service;

    @PostMapping("/hall")
    public Hall createHall(@RequestBody CreateHallRequest request) {
        return service.createHall(request);
    }

    @GetMapping("/hall/{id}")
    public Hall getHall(@PathVariable Long id) {
        return service.getHall(id);
    }
}
