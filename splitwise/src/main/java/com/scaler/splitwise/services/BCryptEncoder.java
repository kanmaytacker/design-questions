package com.scaler.splitwise.services;

import com.scaler.splitwise.services.interfaces.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptEncoder implements PasswordEncoder {

    private BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
    @Override
    public String encode(String password) {
        return bCryptEncoder.encode(password);
    }

    @Override
    public boolean matches(String plainText, String hashed) {
        return bCryptEncoder.matches(plainText, hashed);
    }
}
