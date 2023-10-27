package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.CreateShowRequest;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.services.ShowService;
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