package com.example.metroapp.service;

import com.example.metroapp.interfaces.IStationService;
import com.example.metroapp.model.Line;
import com.example.metroapp.model.Station;
import com.example.metroapp.repository.LineRepo;
import com.example.metroapp.repository.StationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StationService implements IStationService {
    @Autowired
    private StationRepo stationRepo;

    @Autowired
    private LineRepo lineRepo;

    private double getDistanceBetweenPoints(double lat1, double long1, double lat2,double long2) {
        double distance = org.apache.lucene.util.SloppyMath.haversinMeters(lat1, long1, lat2, long2);
        return distance;
    }

    @Override
    public Station getClosestStation(double latitude, double longitude) {
        List<Station> stations = stationRepo.findAll();
        Station nearestStation = new Station();
        nearestStation.setName(stations.get(0).getName());
        nearestStation.setLatitude(stations.get(0).getLatitude());
        nearestStation.setLongitude(stations.get(0).getLongitude());
        nearestStation.setId(stations.get(0).getId());
        nearestStation.setRegion(stations.get(0).getRegion());
        double minDistance = getDistanceBetweenPoints(latitude,longitude,stations.get(0).getLatitude(),stations.get(0).getLongitude());
        for(int i = 1 ; i < stations.size() ; i++)
        {
            double tmpDistance = getDistanceBetweenPoints(latitude,longitude,stations.get(i).getLatitude(),stations.get(i).getLongitude());
            if(tmpDistance <= minDistance)
            {
                minDistance = tmpDistance;
                nearestStation.setId(stations.get(i).getId());
                nearestStation.setName(stations.get(i).getName());
                nearestStation.setLatitude(stations.get(i).getLatitude());
                nearestStation.setLongitude(stations.get(i).getLongitude());
                nearestStation.setRegion(stations.get(i).getRegion());
            }
        }
        nearestStation.setLines(stationRepo.findById(nearestStation.getId()).get().getLines());
        return nearestStation;
    }

    @Override
    public Map<String, Integer> getAllStations()
    {
        List<Station> stations = stationRepo.findAll();
        Map<String,Integer> mp = new HashMap<>();
        for(Station lStation : stations)
        {
            for(Line line : lStation.getLines())
            {
                if(!mp.containsKey(lStation.getName()))
                    mp.put(lStation.getName(),line.getId());
                else
                    break;
            }
        }
        return mp;
    }


}
