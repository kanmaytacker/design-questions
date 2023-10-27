package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}