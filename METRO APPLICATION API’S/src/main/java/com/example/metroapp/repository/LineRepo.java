package com.example.metroapp.repository;

import com.example.metroapp.model.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LineRepo extends JpaRepository<Line, Integer> {
}
