package com.scaler.lld.bookmyshow.services.password;

import org.springframework.stereotype.Service;

@Service
public class PlainTextPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(String plainText) {
        return "encoded-" + plainText;
    }
}
