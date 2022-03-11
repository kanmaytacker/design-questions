package com.scaler.lld.bookmyshow.services;

import java.util.List;

import com.scaler.lld.bookmyshow.models.Movie;
import com.scaler.lld.bookmyshow.repositories.interfaces.MovieRepository;

import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> listMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> searchMovies(String movieName) {
        return movieRepository.findByName(movieName);
    }

}
