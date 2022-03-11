package com.scaler.lld.bookmyshow.repositories.interfaces;

import java.util.List;

import com.scaler.lld.bookmyshow.models.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByName(String movieName);
}
