package com.example.metroapp.interfaces;

import com.example.metroapp.model.Station;


import java.util.List;
import java.util.Map;

public interface IStationService {
    public Station getClosestStation(double latitude, double longitude);
    public Map<String, Integer> getAllStations();

}
