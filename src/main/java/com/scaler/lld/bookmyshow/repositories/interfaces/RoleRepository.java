package com.scaler.lld.bookmyshow.repositories.interfaces;

import java.util.Optional;

import com.scaler.lld.bookmyshow.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getRoleByName(String customer);
}