package com.example.metroapp.payload.request;

import com.example.metroapp.model.Station;

public class EndStationRequest {
    private String[] prevStation ;
    private Station station;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String[] getPrevStation() {
        return prevStation;
    }

    public void setPrevStation(String[] prevStation) {
        this.prevStation = prevStation;
    }

}
