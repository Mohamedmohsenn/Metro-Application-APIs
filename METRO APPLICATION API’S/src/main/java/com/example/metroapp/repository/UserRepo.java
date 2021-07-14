package com.example.metroapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.metroapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

