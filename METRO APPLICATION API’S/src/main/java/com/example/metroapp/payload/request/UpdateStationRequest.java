package com.example.metroapp.payload.request;

import com.example.metroapp.model.Station;

public class UpdateStationRequest {
    Integer id;
    Station station;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
