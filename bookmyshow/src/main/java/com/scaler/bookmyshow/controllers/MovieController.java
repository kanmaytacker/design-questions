package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.CreateMovieRequest;
import com.scaler.bookmyshow.dtos.CreateShowRequest;
import com.scaler.bookmyshow.models.Movie;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.services.MovieService;
import com.scaler.bookmyshow.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @PostMapping("/movie")
    public Movie createMovie(@RequestBody CreateMovieRequest request) {
        return movieService.createMovie(request.toMovie());
    }
}