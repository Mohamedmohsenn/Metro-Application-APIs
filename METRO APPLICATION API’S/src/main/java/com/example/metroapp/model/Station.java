package com.example.metroapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Station {
    private Integer station_id;
    private String station_name;
    private double station_latitude;
    private double station_longitude;
    private Set<Line> lines = new HashSet<>();



    public Station(){}

    public Station(Integer id,String name,double latitude, double longitude) {
        this.station_id = id;
        this.station_name = name;
        this.station_latitude = latitude;
        this.station_longitude = longitude;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return station_id;
    }

    @ManyToMany
    @JoinTable(name = "station_line", joinColumns = { @JoinColumn(name = "station_id") },
            inverseJoinColumns = { @JoinColumn(name = "line_id") })
    @JsonManagedReference
    public Set<Line> getLines() {
        return lines;
    }

    public void setLines(Set<Line> lines) {
        for(Line line : lines)
        this.lines.add(line);
    }



    public void setId(Integer id) {
        this.station_id = id;
    }

    public String getName() {
        return station_name;
    }

    public void setName(String name) {
        this.station_name = name;
    }

    public double getLatitude() {
        return station_latitude;
    }

    public void setLatitude(double latitudue) {
        this.station_latitude = latitudue;
    }

    public double getLongitude() {
        return station_longitude;
    }

    public void setLongitude(double longitude) {
        this.station_longitude = longitude;
    }
}
