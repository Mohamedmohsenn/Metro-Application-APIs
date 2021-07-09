package com.example.metroapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.metroapp.model.Station;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StationRepo extends JpaRepository<Station, Integer>{
}
