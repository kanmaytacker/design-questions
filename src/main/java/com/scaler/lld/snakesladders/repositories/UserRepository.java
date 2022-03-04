package com.scaler.lld.snakesladders.repositories;

import java.util.ArrayList;
import java.util.List;

import com.scaler.lld.snakesladders.models.User;

public class UserRepository {

    List<User> users = new ArrayList<>();

    public User save(User user) {
        this.users.add(user);
        return user;
    }
    
}
