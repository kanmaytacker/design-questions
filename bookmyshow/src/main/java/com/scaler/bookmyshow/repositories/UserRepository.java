package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

// 1. Create an interface
// 2. Annotate it with @Repository
// 3. extends JpaRepository<ENTITY_TYPE, ID_TYPE>
