package com.behlole.authentication.services;

import com.behlole.authentication.repositories.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    AuthenticationRepository authenticationRepository;

    public boolean isFraudulent(Integer customerId) {
        return false;
    }
}
