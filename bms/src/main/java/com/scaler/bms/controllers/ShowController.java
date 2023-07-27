package com.scaler.bms.controllers;

import com.scaler.bms.dtos.CreateShowRequest;
import com.scaler.bms.models.Show;
import com.scaler.bms.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ShowController {

    private ShowService showService;

    // READ API for show
    @GetMapping("/show/{id}")
    public Show readShow(@PathVariable Long id) {
        return showService.getShow(id);
    }

    // CREATE SHOW API
    @PostMapping("/show")
    public Show createShow(@RequestBody CreateShowRequest request) {
        return showService.createShow(request);
    }
}
