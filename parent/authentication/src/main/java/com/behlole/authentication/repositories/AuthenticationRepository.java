package com.behlole.authentication.repositories;

import com.behlole.authentication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<User, Long> {
}
