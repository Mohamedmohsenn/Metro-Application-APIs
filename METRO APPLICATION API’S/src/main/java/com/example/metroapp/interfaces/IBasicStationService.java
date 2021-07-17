package com.example.metroapp.interfaces;

import com.example.metroapp.model.Station;

import java.util.List;

public interface IBasicStationService {
    public List<Station> getAllStations();
    public boolean addStation(String[] prevStation,Station station,String[] afterStation);
    public boolean addStation(String[] prevStation,Station station);
    public boolean addStation(Station station,String[] afterStation);
    public boolean updateStation(Integer id,Station newStation);
}
