package com.scaler.bms.repositories;

import com.scaler.bms.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
}