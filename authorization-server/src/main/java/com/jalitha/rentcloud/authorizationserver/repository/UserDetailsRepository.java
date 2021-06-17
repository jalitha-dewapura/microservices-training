package com.jalitha.rentcloud.authorizationserver.repository;

import com.jalitha.rentcloud.authorizationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername (String username);
}
