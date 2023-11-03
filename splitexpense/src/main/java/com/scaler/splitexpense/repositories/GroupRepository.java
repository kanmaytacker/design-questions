package com.scaler.splitexpense.repositories;

import com.scaler.splitexpense.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}