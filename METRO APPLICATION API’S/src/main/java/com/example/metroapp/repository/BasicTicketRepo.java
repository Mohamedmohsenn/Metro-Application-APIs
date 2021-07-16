package com.example.metroapp.repository;

import com.example.metroapp.model.BasicTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicTicketRepo extends JpaRepository<BasicTicket, Integer> {
}
