package com.scaler.lld.bookmyshow.repositories.interfaces;

import java.util.List;

import com.scaler.lld.bookmyshow.models.Admin;
import com.scaler.lld.bookmyshow.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findAllByUserAndPhone1AndPhone2(User user, String phone1, String phone2);

}
