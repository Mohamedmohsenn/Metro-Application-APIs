package com.example.metroapp.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    private Integer id;
    private Integer price;
    private Integer maximum_trips;
    private String source_station;
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMaximumTrips() {
        return maximum_trips;
    }

    public void setMaximumTrips(Integer maximum_trips) {
        this.maximum_trips = maximum_trips;
    }

    public String getSource_station() {
        return source_station;
    }

    public void setSource_station(String source_station) {
        this.source_station = source_station;
    }

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
