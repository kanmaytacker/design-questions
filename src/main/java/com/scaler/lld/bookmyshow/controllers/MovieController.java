package com.scaler.lld.bookmyshow.controllers;

import java.util.List;

import com.scaler.lld.bookmyshow.models.Movie;
import com.scaler.lld.bookmyshow.services.MovieService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> requestMethodName() {
        return movieService.listMovies();
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public List<Movie> requestMethodName(@RequestParam(value = "movieName", required = true) String movieName) {
        return movieService.searchMovies(movieName);
    }

}
