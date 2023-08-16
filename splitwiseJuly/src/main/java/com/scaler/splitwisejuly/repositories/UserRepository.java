package com.scaler.splitwisejuly.repositories;

import com.scaler.splitwisejuly.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
