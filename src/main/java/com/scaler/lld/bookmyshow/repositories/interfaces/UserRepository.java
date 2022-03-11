package com.scaler.lld.bookmyshow.repositories.interfaces;

import java.util.Optional;

import com.scaler.lld.bookmyshow.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);

}