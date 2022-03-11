package com.scaler.lld.bookmyshow.services;

import com.scaler.lld.bookmyshow.models.Role;
import com.scaler.lld.bookmyshow.repositories.interfaces.RoleRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getRole(String roleName) {
        return roleRepository.getRoleByName(roleName).get();
    }

}
