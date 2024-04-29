package com.behlole.authentication.services;

import com.behlole.authentication.models.User;
import com.behlole.authentication.repositories.AuthenticationRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Service
public class AuthenticationService {
    @Autowired
    AuthenticationRepository authenticationRepository;
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public boolean isFraudulent(Integer customerId) {
        return false;
    }

    @Getter
    private List<User> users = new ArrayList<User>();

    public AuthenticationService() {
        users.add(
                new User(
                        UUID.randomUUID(),
                        "behlole",
                        "aqil",
                        "behloleaqil@gmail.com",
                        passwordEncoder().encode("password")
                )
        );
        users.add(new User(
                UUID.randomUUID(),
                "adminBehlole",
                "adminAqil",
                "adminBehloleAqil@gmail.com",
                passwordEncoder().encode("password")
        ));
    }
}
