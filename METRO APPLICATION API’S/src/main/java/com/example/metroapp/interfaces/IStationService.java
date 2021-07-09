package com.example.metroapp.interfaces;

import com.example.metroapp.model.Station;

public interface IStationService {
    public Station getClosestStation(double latitude, double longitude);
}
