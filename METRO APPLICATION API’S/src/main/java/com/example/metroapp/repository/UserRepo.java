package com.example.metroapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.metroapp.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}

