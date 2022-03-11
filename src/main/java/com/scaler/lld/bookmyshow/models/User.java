package com.scaler.lld.bookmyshow.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.scaler.lld.bookmyshow.services.password.PasswordEncoder;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USERS")
public class User extends Auditable {
    
    private String username;
    private String hashedSaltedPassword;

    public User(String username) {
        this.username = username;
    }

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    public void setPassword(String password, PasswordEncoder passwordEncoder) {
        if (password.length() < 8) {
            throw new RuntimeException("must have at least 8 characters");
        }
        String salt = "salt"; // from some service
        this.hashedSaltedPassword = passwordEncoder.encode(password + salt);
        this.hashedSaltedPassword += ";" + salt;
    }

    public boolean checkPassword(String password, PasswordEncoder passwordEncoder) {
        // this method checks whether the given password
        // matches the actual password
        String salt = this.hashedSaltedPassword.split(";")[1];
        // password-encoder is a dependency that we need
        String encoded = passwordEncoder.encode(password + salt) + salt;
        return encoded.equals(this.getHashedSaltedPassword());
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

}
