package com.example.metroapp.interfaces;

import com.example.metroapp.model.Station;

import java.util.List;

public interface IStationService {
    public Station getClosestStation(double latitude, double longitude);
    public List<Station> getAllStations();
    public List<Station> getCertainLineStations(Integer id);

}
